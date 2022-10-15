package com.ingsoftw.v01.natour_webservices.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "activationToken")
public class ActivationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token", nullable = false)
    private Long id;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "activation_date", nullable = false)
    private Date activationDate;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_user", nullable = false)
    private Utente user;

    public ActivationToken() {}

    public ActivationToken(Long id, String token, Date activationDate, Utente user) {
        this.id = id;
        this.token = token;
        this.activationDate = activationDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Utente getUser() {
        return user;
    }

    public void setUser(Utente user) {
        this.user = user;
    }
}