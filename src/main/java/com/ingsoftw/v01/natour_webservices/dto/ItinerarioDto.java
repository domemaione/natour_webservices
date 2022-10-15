package com.ingsoftw.v01.natour_webservices.dto;

public class ItinerarioDto {
    private Long idItinerary;
    private String name;
    private Double difficulty;
    private Double score;
    private Double duration;
    private Long idUser;

    public ItinerarioDto() {}

    public ItinerarioDto(Long idItinerary, String name, Double difficulty, Double score, Double duration, Long idUser) {
        this.idItinerary = idItinerary;
        this.name = name;
        this.difficulty = difficulty;
        this.score = score;
        this.duration = duration;
        this.idUser = idUser;
    }

    public Long getIdItinerary() {
        return this.idItinerary;
    }

    public void setIdItinerary(Long idItinerary) {
        this.idItinerary = idItinerary;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
