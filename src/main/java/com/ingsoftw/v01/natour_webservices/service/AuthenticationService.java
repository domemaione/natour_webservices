package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.exception.AuthenticationException;
import com.ingsoftw.v01.natour_webservices.exception.EmailException;
import com.ingsoftw.v01.natour_webservices.mapper.UtenteMapper;
import com.ingsoftw.v01.natour_webservices.model.ActivationToken;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.repository.ActivationTokenRepository;
import com.ingsoftw.v01.natour_webservices.repository.UtenteRepository;
import com.ingsoftw.v01.natour_webservices.utils.EmailValidator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
//import java.sql.Date;

@Service
public class AuthenticationService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteMapper utenteMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ActivationTokenRepository activationTokenRepository;


    public UtenteDto registrazione(UtenteDto utente) throws Exception {

        if(!EmailValidator.patternMatches(utente.getEmail(), EmailValidator.regexPattern))
            throw new EmailException("email non valida");

        Optional<Utente> opt = utenteRepository.findByEmail(utente.getEmail());

        //email valida e verifica nel db se è presente
        if(opt.isPresent())
            throw new AuthenticationException("utente già registrato");


        ActivationToken activationToken = new ActivationToken();
        String token = UUID.randomUUID().toString();
        activationToken.setToken(token);
        activationToken.setActivationDate(new Date());
        activationToken.setUser(utenteMapper.toModel(utente));
        emailService.sendEmailWithAttachment(activationToken);

       // Utente utente_registrato = utenteRepository.save(utenteMapper.toModel(utente));
       // ActivationToken activationToken = activationTokenService.saveToken(utente_registrato);
        Utente newUser = activationTokenRepository.save(activationToken).getUser();
        return utenteMapper.toDto(newUser);
    }

    public UtenteDto attivaUtente(String token) throws Exception {

        Optional<ActivationToken> opt = activationTokenRepository.findByToken(token);

        if(opt.isEmpty())
            throw new AuthenticationException("token non valido");

        Date firstDate = new Date();
        Date secondDate = opt.get().getActivationDate();
        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if(diff > 0)
            throw new AuthenticationException("token scaduto");

        Utente utente = opt.get().getUser();
        utente.setEnable(true);
        activationTokenRepository.delete(opt.get());
       utenteRepository.save(utente);

        return null;
    }

    public UtenteDto login(UtenteDto utente) throws Exception {
        Optional<Utente> opt = utenteRepository.findByEmail(utente.getEmail()); //nel db restituisce sempre una model quindi il ritorno è un Utente

        if(opt.isEmpty())
            throw new AuthenticationException("Utente non registrato");
        Utente utenteRegistrato = opt.get(); //opt.get restituisce l'utente
        if(!utenteRegistrato.isEnable())
            throw new AuthenticationException("Utente non attivo");
        if(!utente.getPassword().equals(utenteRegistrato.getPassword())) //se la passw non corrisponde
            throw new AuthenticationException("Password non valida");

        ActivationToken activationToken = new ActivationToken();
        String token = UUID.randomUUID().toString();
        //Qui dovrei criptare il token
        utenteRegistrato.setToken(token); //salvo il token in utenteregistrato che si è loggato
        utenteRepository.save(utenteRegistrato); //aggiorno nel db l'utenteRegistrato con il suo token
        return utenteMapper.toDto(utenteRegistrato); //restituisco l'utenteRegistrato di tipo UtenteDto (tramite il mapper)
    }

   
    public String getJWTToken() throws Exception {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                // .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }



}
