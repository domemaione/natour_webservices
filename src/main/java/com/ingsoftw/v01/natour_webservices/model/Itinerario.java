package com.ingsoftw.v01.natour_webservices.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.Set;


@Entity
@Table(name = "ITINERARI")
public class Itinerario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autogenerante - primary key
    private long id;
    
    @Column(name = "NOME")
    private String nome;

    @Column(name = "DURATA")
    @Min(value=0)
    private Double durata;

    @Column(name = "DIFFICOLTA")//toDo
    @Min(value=0)
    @Max(value=5)
  //  @Range(min= 0, max= 5)
    private Double difficolta;
    
    @Column(name = "PUNTEGGIO") //toDo
    @Min(value=0)
    @Max(value=5)
    private Double punteggio;

    @ManyToOne
    @JoinColumn(name="utente_id", nullable=false)
    @JsonIgnore //ignora i campi dell'oggetto interno di un altro oggetto
    private Utente utente;

    @OneToMany(mappedBy = "itinerario", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Coordinata> coordinate;

    public Itinerario() {}

    public Itinerario(long id, String nome, Double durata, Double difficolta, Double punteggio, Utente utente, Set<Coordinata> coordinate) {
        this.id = id;
        this.nome = nome;
        this.durata = durata;
        this.difficolta = difficolta;
        this.punteggio = punteggio;
        this.utente = utente;
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Set<Coordinata> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Set<Coordinata> coordinate) {
        this.coordinate = coordinate;
    }
}
