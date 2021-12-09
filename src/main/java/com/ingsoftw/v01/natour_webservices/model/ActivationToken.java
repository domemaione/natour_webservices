package com.ingsoftw.v01.natour_webservices.model;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVATION_TOKEN")
public class ActivationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autogenerante - primary key
    private long id;
}
