package com.ingsoftw.v01.natour_webservices.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ValutazionePK implements Serializable {

        @Column(name="id_user")
        private Long idUser;

        @Column(name="id_itinerary")
        private Long idItinerary;

        // standard getters and setters

        public ValutazionePK() {}

    public ValutazionePK(Long idUser, Long idItinerary) {
        this.idUser = idUser;
        this.idItinerary = idItinerary;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdItinerary() {
        return idItinerary;
    }

    public void setIdItinerary(Long idItinerary) {
        this.idItinerary = idItinerary;
    }
}
