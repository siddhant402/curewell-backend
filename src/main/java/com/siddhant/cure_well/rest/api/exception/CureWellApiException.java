package com.siddhant.cure_well.rest.api.exception;

import org.springframework.http.HttpStatus;

public class CureWellApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public CureWellApiException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public CureWellApiException(String customMessage, HttpStatus status, String message){
        super(customMessage);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}