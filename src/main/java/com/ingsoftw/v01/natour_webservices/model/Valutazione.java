package com.ingsoftw.v01.natour_webservices.model;


import com.ingsoftw.v01.natour_webservices.utils.ValidPassword;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="valutazione")
public class Valutazione {

    @EmbeddedId
    private ValutazionePK valutazionePK;

    @Column(name="difficulty")
    private Double diffiiculty;

    @Column(name="score")
    private Double score;

    public Valutazione() {}

    public Valutazione(ValutazionePK valutazionePK, Double diffiiculty, Double score) {
        this.valutazionePK = valutazionePK;
        this.diffiiculty = diffiiculty;
        this.score = score;
    }

    public ValutazionePK getValutazionePK() {
        return valutazionePK;
    }

    public void setValutazionePK(ValutazionePK valutazionePK) {
        this.valutazionePK = valutazionePK;
    }

    public Double getDiffiiculty() {
        return diffiiculty;
    }

    public void setDiffiiculty(Double diffiiculty) {
        this.diffiiculty = diffiiculty;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
