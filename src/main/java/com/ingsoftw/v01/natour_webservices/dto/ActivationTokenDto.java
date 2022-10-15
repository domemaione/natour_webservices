package com.ingsoftw.v01.natour_webservices.dto;

import com.ingsoftw.v01.natour_webservices.model.Utente;

import java.sql.Date;

public class ActivationTokenDto {
    private Long idToken;
    private String token;
    private java.sql.Date activationDate;
    private Utente user;

    public ActivationTokenDto() {}

    public ActivationTokenDto(Long idToken, String token, Date activationDate, Utente user) {
        this.idToken = idToken;
        this.token = token;
        this.activationDate = activationDate;
        this.user = user;
    }

    public Long getIdToken() {
        return idToken;
    }

    public void setIdToken(Long idToken) {
        this.idToken = idToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Utente getUser() {
        return user;
    }

    public void setUser(Utente user) {
        this.user = user;
    }
}
