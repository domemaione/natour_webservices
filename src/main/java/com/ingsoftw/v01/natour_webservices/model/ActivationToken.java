package com.ingsoftw.v01.natour_webservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACTIVATION_TOKEN")
public class ActivationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autogenerante - primary key
    private long id;

    @Column(name="TOKEN")
    private String token;

    @Column(name="expiry_date")
    private Timestamp expiryDate;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="utente_id")
    @JsonIgnore
    private Utente utente;

    public ActivationToken() {}

    public ActivationToken(long id, String token, Utente utente) {
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

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
