package com.example.navvistaskbackend.exception;

public class EntityNotExistsException extends UserFriendlyException{
    public EntityNotExistsException(String message, Object... properties){
        super(message, properties);
    }

    public EntityNotExistsException(String message, Throwable throwable, Object... properties){
        super(message, throwable, properties);
    }
}

