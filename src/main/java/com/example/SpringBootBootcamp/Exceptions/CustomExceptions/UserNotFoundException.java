package com.example.SpringBootBootcamp.Exceptions.CustomExceptions;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
