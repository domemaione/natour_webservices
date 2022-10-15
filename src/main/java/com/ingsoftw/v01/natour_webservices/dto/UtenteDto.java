package com.ingsoftw.v01.natour_webservices.dto;

import java.sql.Date;

public class UtenteDto {
    private Long idUser;
    private String fullName;
    private java.sql.Date birthDate;
    private String email;
    private String password;
    private String token;
    private boolean enable;

    public UtenteDto() {}

    public UtenteDto(Long idUser, String fullName, Date birthDate, String email, String password, String token, boolean enable) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.token = token;
        this.enable = enable;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
