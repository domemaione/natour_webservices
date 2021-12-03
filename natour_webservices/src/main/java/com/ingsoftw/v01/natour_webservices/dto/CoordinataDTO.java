package com.ingsoftw.v01.natour_webservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;

import java.util.Date;

public class CoordinataDTO {
    private long id;
    private Double lat;
    private Double lon;
    private Date createdAt;
    private Itinerario itinerario;

    public CoordinataDTO(long id, Double lat, Double lon, Date createdAt, Itinerario itinerario) {
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


