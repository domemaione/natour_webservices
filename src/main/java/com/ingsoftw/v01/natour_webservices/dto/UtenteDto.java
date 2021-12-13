package com.ingsoftw.v01.natour_webservices.dto;
import com.ingsoftw.v01.natour_webservices.model.ActivationToken;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import lombok.*;

import java.sql.Date;
import java.util.Set;


public class UtenteDto {
    
    private long id;
    private String email;
    private String password;
    private String nomeCompleto;
    private Date dataNascita;
    private boolean enable;
    private Set<Itinerario> itinerari;

    public UtenteDto() {}

    public UtenteDto(long id, String email, String password, String nomeCompleto, Date dataNascita, boolean enable, Set<Itinerario> itinerari) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nomeCompleto = nomeCompleto;
        this.dataNascita = dataNascita;
        this.enable = enable;
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

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<Itinerario> getItinerari() {
        return itinerari;
    }

    public void setItinerari(Set<Itinerario> itinerari) {
        this.itinerari = itinerari;
    }
}
