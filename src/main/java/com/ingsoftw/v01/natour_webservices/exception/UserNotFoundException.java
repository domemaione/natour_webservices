package com.ingsoftw.v01.natour_webservices.exception;


public class UserNotFoundException  extends Exception{  //è un CheckedException

    private static final long serialVersionUID = 124368356L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
