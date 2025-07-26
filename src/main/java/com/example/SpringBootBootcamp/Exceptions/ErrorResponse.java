package com.example.SpringBootBootcamp.Exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    public String message;
    public HttpStatus status;
    public String error;
    public LocalDateTime timestamp;

    public ErrorResponse(String message, HttpStatus status, String error){
        this.message = message;
        this.status = status;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}
