package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.model.Utente;

import javax.mail.MessagingException;
import java.io.IOException;

public interface IAuthenticationService {

    public UtenteDto registrazione(UtenteDto utente) throws MessagingException, IOException;
    public UtenteDto attivaUtente(String token);
    public UtenteDto login(UtenteDto utente);
    public String getJWTToken();
}
