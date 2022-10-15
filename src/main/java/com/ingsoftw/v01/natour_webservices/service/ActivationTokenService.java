package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.mapper.ActivationTokenMapper;
import com.ingsoftw.v01.natour_webservices.model.ActivationToken;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.repository.ActivationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActivationTokenService  {

    @Autowired
    private ActivationTokenRepository activationTokenRepository;

    @Autowired
    private ActivationTokenMapper activationTokenMapper;

    //genera il token e
   public ActivationToken saveToken(Utente utente){

       ActivationToken activationToken = new ActivationToken();
       String token = UUID.randomUUID().toString(); //genera una stringa random
       activationToken.setToken(token);
       activationToken.setUser(utente);
       activationTokenRepository.save(activationToken); //metto nel db il token

       //Qui vado a dare un tempo di validità del token
       //private Timestamp calculateExpiryDate(int expiryTimeInMinutes){
          // Calendar cal = Calendar.getInstance();
         //  cal.add(Calendar.MINUTE,expiryTimeInMinutes);
         //  return new Timestamp(cal.getTime().getTime());
       //}

       //emailService.sendEmail(token);
       return activationToken;
   }

}
