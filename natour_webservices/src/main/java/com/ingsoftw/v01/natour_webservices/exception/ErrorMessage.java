package com.ingsoftw.v01.natour_webservices.exception;


import java.util.Date;

public class ErrorMessage {
    private Date time;
    private String message;
    private String exception;

    public ErrorMessage() {}

    public ErrorMessage(Date time, String message, String exception) {
        this.time = time;
        this.message = message;
        this.exception = exception;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
