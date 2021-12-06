package com.ingsoftw.v01.natour_webservices.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COORDINATE")
public class Coordinata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autogenerante - primary key
    private long id;


    @Column(name="LAT")
    private Double lat;

    @Column(name="LON")
    private Double lon;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="itinerario_id", nullable=false)
    @JsonIgnore
    private Itinerario itinerario;

    public Coordinata(){}


    public Coordinata(long id, Double lat, Double lon, Date createdAt, Itinerario itinerario) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.createdAt = createdAt;
        this.itinerario = itinerario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }
}
