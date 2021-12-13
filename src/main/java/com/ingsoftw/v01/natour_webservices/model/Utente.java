package com.ingsoftw.v01.natour_webservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name="UTENTI")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autogenerante - primary key
    private long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="nomeCompleto")
    private String nomeCompleto;

    @Column(name="dataNascita")
    private Date data;

    //@OneToOne(mappedBy = "utente", cascade = CascadeType.ALL)
   // @JsonIgnore
   // private ActivationToken activationToken;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utente")  //lazy ti carica questo set solo quando lo richiedi
    @JsonIgnore //ignora l'ogetto interno in fase di visualizzazione
    private Set<Itinerario> itinerari;

    public Utente() {}

    public Utente(long id, String email, String password, String nomeCompleto, Date data, Set<Itinerario> itinerari) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nomeCompleto = nomeCompleto;
        this.data = data;
        this.itinerari = itinerari;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /*public ActivationToken getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(ActivationToken activationToken) {
        this.activationToken = activationToken;
    }*/

    public Set<Itinerario> getItinerari() {
        return itinerari;
    }

    public void setItinerari(Set<Itinerario> itinerari) {
        this.itinerari = itinerari;
    }
}