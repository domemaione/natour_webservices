package com.ingsoftw.v01.natour_webservices.dto;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import lombok.*;

import java.sql.Date;
import java.util.Set;


public class UtenteDto {
    
    private long id;
    private String email;
    private String password;
    private String nomeCompleto;
    private Date data;
    private Set<Itinerario> itinerari;

    public UtenteDto() {
    }

    public UtenteDto(long id, String email, String password, String nomeCompleto, Date data, Set<Itinerario> itinerari) {
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

    public Set<Itinerario> getItinerari() {
        return itinerari;
    }

    public void setItinerari(Set<Itinerario> itinerari) {
        this.itinerari = itinerari;
    }
}
