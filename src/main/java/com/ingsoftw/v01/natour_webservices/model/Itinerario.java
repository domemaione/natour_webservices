package com.ingsoftw.v01.natour_webservices.model;

import javax.persistence.*;

@Entity
@Table(name = "itinerari")
public class Itinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_itinerary", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "difficulty", nullable = false)
    private Double difficulty;

    @Column(name = "score", nullable = false)
    private Double score;

    @Column(name = "duration", nullable = false)
    private Double duration;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    public Itinerario() {}

    public Itinerario(Long id, String name, Double difficulty, Double score, Double duration, Long idUser) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.score = score;
        this.duration = duration;
        this.idUser = idUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}