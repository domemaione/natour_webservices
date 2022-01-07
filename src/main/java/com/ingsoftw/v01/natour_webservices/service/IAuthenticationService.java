package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.model.Utente;

import javax.mail.MessagingException;
import java.io.IOException;

public interface IAuthenticationService {

    public UtenteDto registrazione(UtenteDto utente) throws Exception;
    public UtenteDto attivaUtente(String token) throws Exception;
    public UtenteDto login(UtenteDto utente) throws Exception;
    public String getJWTToken() throws Exception;
}
