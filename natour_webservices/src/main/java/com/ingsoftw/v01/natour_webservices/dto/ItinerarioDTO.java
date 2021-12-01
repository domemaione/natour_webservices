package com.ingsoftw.v01.natour_webservices.dto;


public class ItinerarioDTO {

    private long id;
    private String nome;
    private Integer durata;
    private Integer difficolta;
    private Float punteggio;
    
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
