package com.ingsoftw.v01.natour_webservices.dto;

import com.ingsoftw.v01.natour_webservices.model.Utente;

import java.util.Date;

public class ActivationTokenDto {

    private long id;
    private String token;
    private Utente utente;
    private Date activation_date;

    public ActivationTokenDto() {}


    public ActivationTokenDto(long id, String token, Utente utente, Date activation_date) {
        this.id = id;
        this.token = token;
        this.utente = utente;
        this.activation_date = activation_date;
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

    public Date getActivation_date() {
        return activation_date;
    }

    public void setActivation_date(Date activation_date) {
        this.activation_date = activation_date;
    }
}
