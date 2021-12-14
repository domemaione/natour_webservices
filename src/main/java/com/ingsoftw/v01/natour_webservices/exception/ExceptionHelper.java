package com.ingsoftw.v01.natour_webservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Set;

@ControllerAdvice
public class ExceptionHelper {



    @ExceptionHandler(value = {Exception.class}) //spring gestisce le eccezioni
    public ResponseEntity<Object> handleException(Exception ex){

        ex.printStackTrace();
        String errorMessageDescription = ex.getLocalizedMessage() == null? ex.toString(): ex.getLocalizedMessage();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDescription,ex.getClass().toString());

        return new ResponseEntity<Object>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); //restituisce il messaggio al client
    }

    @ExceptionHandler(value = {EmailException.class}) //spring gestisce le eccezioni dell'email
    public ResponseEntity<Object> handleEmailException(Exception ex){

        ex.printStackTrace();
        String errorMessageDescription = ex.getLocalizedMessage() == null? ex.toString(): ex.getLocalizedMessage(); //ex è l'oggetto eccezione
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDescription,ex.getClass().toString());

        return new ResponseEntity<Object>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); //restituisce il messaggio al client
    }

    @ExceptionHandler(value = {AuthenticationException.class}) //spring gestisce le eccezioni dell'email
    public ResponseEntity<Object> handleAuthenticationException(Exception ex){

        ex.printStackTrace();
        String errorMessageDescription = ex.getLocalizedMessage() == null? ex.toString(): ex.getLocalizedMessage(); //ex è l'oggetto eccezione
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDescription,ex.getClass().toString());

        return new ResponseEntity<Object>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); //restituisce il messaggio al client
    }

    @ExceptionHandler(value = {ConstraintViolationException.class}) //spring gestisce le eccezioni dell'email
    public ResponseEntity<Object> handlePasswordException(ConstraintViolationException ex){

        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            message.append(violation.getMessage().concat(";"));
        }

        ex.printStackTrace();
        //  String errorMessageDescription = ex.getLocalizedMessage() == null? ex.toString(): ex.getLocalizedMessage(); //ex è l'oggetto eccezione
        ErrorMessage errorMessage = new ErrorMessage(new Date(),message.toString(),ex.getClass().toString());

        return new ResponseEntity<Object>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); //restituisce il messaggio al client
    }


}
