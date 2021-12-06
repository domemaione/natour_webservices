package com.ingsoftw.v01.natour_webservices.dto;


import com.ingsoftw.v01.natour_webservices.model.Coordinata;

import java.util.Set;

public class ItinerarioDto {

    private long id;
    private String nome;
    private Integer durata;
    private Integer difficolta;
    private Float punteggio;
    private Set<Coordinata> coordinate;

    public ItinerarioDto() {}

    public ItinerarioDto(long id, String nome, Integer durata, Integer difficolta, Float punteggio, Set<Coordinata> coordinate) {
        this.id = id;
        this.nome = nome;
        this.durata = durata;
        this.difficolta = difficolta;
        this.punteggio = punteggio;
        this.coordinate = coordinate;
    }

    public Set<Coordinata> getCoordinate(){
        return coordinate;
    }

    public void setCoordinate(Set<Coordinata> coordinate) {
        this.coordinate = coordinate;
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

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Integer getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(Integer difficolta) {
        this.difficolta = difficolta;
    }

    public Float getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Float punteggio) {
        this.punteggio = punteggio;
    }
    
}
