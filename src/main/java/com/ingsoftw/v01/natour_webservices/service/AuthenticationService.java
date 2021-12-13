package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.exception.AuthenticationException;
import com.ingsoftw.v01.natour_webservices.exception.EmailException;
import com.ingsoftw.v01.natour_webservices.mapper.ActivationTokenMapper;
import com.ingsoftw.v01.natour_webservices.mapper.ItinerarioMapper;
import com.ingsoftw.v01.natour_webservices.mapper.UtenteMapper;
import com.ingsoftw.v01.natour_webservices.model.ActivationToken;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.repository.ActivationTokenRepository;
import com.ingsoftw.v01.natour_webservices.repository.CoordinataRepository;
import com.ingsoftw.v01.natour_webservices.repository.UtenteRepository;
import com.ingsoftw.v01.natour_webservices.utils.Validation;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteMapper utenteMapper;

    @Autowired
    private ActivationTokenService activationTokenService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ActivationTokenRepository activationTokenRepository;


    @Override
    public UtenteDto registrazione(UtenteDto utente) throws MessagingException, IOException {

        if(!Validation.patternMatches(utente.getEmail(), Validation.regexPattern))
            throw new EmailException("email non valida");

        Optional<Utente> opt = utenteRepository.findByEmail(utente.getEmail());

        //email valida e verifica nel db se è presente
        if(opt.isPresent())
            throw new AuthenticationException("utente già registrato");


        ActivationToken activationToken = new ActivationToken();
        String token = UUID.randomUUID().toString();
        activationToken.setToken(token);
        activationToken.setUtente(utenteMapper.toModel(utente));
        emailService.sendEmailWithAttachment(activationToken);

       // Utente utente_registrato = utenteRepository.save(utenteMapper.toModel(utente));
       // ActivationToken activationToken = activationTokenService.saveToken(utente_registrato);
        Utente utenteNew = activationTokenRepository.save(activationToken).getUtente();
        return utenteMapper.toDto(utenteNew);
    }

    @Override
    public UtenteDto attivaUtente(String token) {

        Optional<ActivationToken> opt = activationTokenRepository.findByToken(token);

        if(opt.isEmpty())
            throw new AuthenticationException("token non valido");

        Utente utente = opt.get().getUtente();
        utente.setEnable(true);
        activationTokenRepository.delete(opt.get());
       utenteRepository.save(utente);

        return null;
    }


    public String getJWTToken() {
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
