package com.ingsoftw.v01.natour_webservices.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    private Integer durata;

    @Column(name = "DIFFICOLTA")//toDo
    @Min(value=0)
    @Max(value=5)
  //  @Range(min= 0, max= 5)
    private Integer difficolta;
    
    @Column(name = "PUNTEGGIO") //toDo
    @Min(value=0)
    @Max(value=5)
    private Float punteggio;


    //OneToMay annotazione uno a molti
    //@OneToMany(mappedBy="itinerario")
    @OneToMany(mappedBy = "itinerario", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Coordinata> coordinate;

    public Itinerario(){}

    public Itinerario(long id, String nome, Integer durata, Integer difficolta, Float punteggio, Set<Coordinata> coordinate) {
        this.id = id;
        this.nome = nome;
        this.durata = durata;
        this.difficolta = difficolta;
        this.punteggio = punteggio;
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

    public Set<Coordinata> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Set<Coordinata> coordinate) {
        this.coordinate = coordinate;
    }
}
