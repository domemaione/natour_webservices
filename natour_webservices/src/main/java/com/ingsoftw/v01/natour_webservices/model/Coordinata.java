package com.ingsoftw.v01.natour_webservices.model;


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
    @JoinColumn(name="itinerarioId",
            insertable=false, updatable=false,
            nullable=false)
    private Itinerario itinerario;

}
