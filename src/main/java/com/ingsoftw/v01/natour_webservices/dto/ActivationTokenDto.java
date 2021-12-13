package com.ingsoftw.v01.natour_webservices.dto;

import com.ingsoftw.v01.natour_webservices.model.Utente;

public class ActivationTokenDto {

    private long id;
    private String token;
    private Utente utente;

    public ActivationTokenDto() {}

    public ActivationTokenDto(long id, String token, Utente utente) {
        this.id = id;
        this.token = token;
        this.utente = utente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
