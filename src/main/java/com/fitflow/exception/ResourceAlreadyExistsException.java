package com.fitflow.exception;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String email){
        super("User already exists with email: " + email);
    }
}
