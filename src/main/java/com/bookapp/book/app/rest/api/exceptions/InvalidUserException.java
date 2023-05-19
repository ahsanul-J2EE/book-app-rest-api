package com.bookapp.book.app.rest.api.exceptions;

public class InvalidUserException extends RuntimeException{


    public InvalidUserException(String message){
        super(message);
    }

}