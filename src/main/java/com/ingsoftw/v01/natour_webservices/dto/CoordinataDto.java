package com.ingsoftw.v01.natour_webservices.dto;

import java.sql.Date;

public class CoordinataDto {
    private Long idCoordinate;
    private java.sql.Date createdAt;
    private Double langitude;
    private Double longitude;
    private String tipology;
    private Long idItinerary;

    public CoordinataDto() {}

    public CoordinataDto(Long idCoordinate, Date createdAt, Double langitude, Double longitude, String tipology, Long idItinerary) {
        this.idCoordinate = idCoordinate;
        this.createdAt = createdAt;
        this.langitude = langitude;
        this.longitude = longitude;
        this.tipology = tipology;
        this.idItinerary = idItinerary;
    }

    public Long getIdCoordinate() {
        return this.idCoordinate;
    }

    public void setIdCoordinate(Long idCoordinate) {
        this.idCoordinate = idCoordinate;
    }

    public java.sql.Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(java.sql.Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getLangitude() {
        return this.langitude;
    }

    public void setLangitude(Double langitude) {
        this.langitude = langitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTipology() {
        return this.tipology;
    }

    public void setTipology(String tipology) {
        this.tipology = tipology;
    }

    public Long getIdItinerary() {
        return this.idItinerary;
    }

    public void setIdItinerary(Long idItinerary) {
        this.idItinerary = idItinerary;
    }
}
