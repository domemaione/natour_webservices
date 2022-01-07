package com.ingsoftw.v01.natour_webservices.dto;


import com.ingsoftw.v01.natour_webservices.model.Coordinata;
import com.ingsoftw.v01.natour_webservices.model.Utente;


import java.util.Set;

public class ItinerarioDto {

    private long id;
    private String nome;
    private Double durata;
    private Double difficolta;
    private Double punteggio;
    private Set<Coordinata> coordinate;
    private Utente utente;

    public ItinerarioDto() {
    }

    public ItinerarioDto(long id, String nome, Double durata, Double difficolta, Double punteggio, Set<Coordinata> coordinate, Utente utente) {
        this.id = id;
        this.nome = nome;
        this.durata = durata;
        this.difficolta = difficolta;
        this.punteggio = punteggio;
        this.coordinate = coordinate;
        this.utente = utente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getDurata() {
        return durata;
    }

    public void setDurata(Double durata) {
        this.durata = durata;
    }

    public Double getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(Double difficolta) {
        this.difficolta = difficolta;
    }

    public Double getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Double punteggio) {
        this.punteggio = punteggio;
    }

    public Set<Coordinata> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Set<Coordinata> coordinate) {
        this.coordinate = coordinate;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
