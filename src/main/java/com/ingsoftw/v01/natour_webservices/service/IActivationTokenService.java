package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.model.ActivationToken;
import com.ingsoftw.v01.natour_webservices.model.Utente;

public interface IActivationTokenService {

    public ActivationToken saveToken(Utente utente);
}
