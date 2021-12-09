package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.exception.AuthenticationException;
import com.ingsoftw.v01.natour_webservices.exception.EmailException;
import com.ingsoftw.v01.natour_webservices.mapper.ItinerarioMapper;
import com.ingsoftw.v01.natour_webservices.mapper.UtenteMapper;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.repository.CoordinataRepository;
import com.ingsoftw.v01.natour_webservices.repository.UtenteRepository;
import com.ingsoftw.v01.natour_webservices.utils.Validation;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteMapper utenteMapper;


    @Override
    public UtenteDto registrazione(UtenteDto utente){

        if(!Validation.patternMatches(utente.getEmail(), Validation.regexPattern))
            throw new EmailException("email non valida");

        Optional<Utente> opt = utenteRepository.findByEmail(utente.getEmail());

        //email valida e verifica nel db se è presente
        if(opt.isPresent())
            throw new AuthenticationException("utente già registrato");

        String token = getJWTToken();
        //utente non è presente allora
       // utenteRepository.save(utenteMapper.toModel(utente));

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
