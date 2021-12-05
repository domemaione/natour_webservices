package com.ingsoftw.v01.natour_webservices.dto;

import java.io.Serializable;

public class JsonResponseDto<T> implements Serializable {

    private static final long serialVersionUID = 23333333L;
    public static  final String SUCCESS="La richiesta è andata a buon fine...";
    public static  final String FAILURE="La richiesta non è andata a buon fine...";
    String message;
    int status;
    T data;

    public JsonResponseDto() {}

    public JsonResponseDto(String message, int status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
