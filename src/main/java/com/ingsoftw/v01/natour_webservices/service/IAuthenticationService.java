package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.model.Utente;

public interface IAuthenticationService {

    public UtenteDto registrazione(UtenteDto utente);
    public String getJWTToken();
}
