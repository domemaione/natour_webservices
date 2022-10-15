package com.ingsoftw.v01.natour_webservices.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "coordinata")
public class Coordinata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordinate", nullable = false)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "langitude", nullable = false)
    private Double langitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "tipology", nullable = false)
    private String tipology;

    @Column(name = "id_itinerary", nullable = false)
    private Long idItinerary;

    public Coordinata() {}

    public Coordinata(Long id, LocalDate createdAt, Double langitude, Double longitude, String tipology, Long idItinerary) {
        this.id = id;
        this.createdAt = createdAt;
        this.langitude = langitude;
        this.longitude = longitude;
        this.tipology = tipology;
        this.idItinerary = idItinerary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Double getLangitude() {
        return langitude;
    }

    public void setLangitude(Double langitude) {
        this.langitude = langitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTipology() {
        return tipology;
    }

    public void setTipology(String tipology) {
        this.tipology = tipology;
    }

    public Long getIdItinerary() {
        return idItinerary;
    }

    public void setIdItinerary(Long idItinerary) {
        this.idItinerary = idItinerary;
    }
}