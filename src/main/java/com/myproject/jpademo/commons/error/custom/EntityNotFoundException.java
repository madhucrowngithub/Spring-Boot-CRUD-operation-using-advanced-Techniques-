package com.myproject.jpademo.commons.error.custom;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(final String message) {
        super(message);
    }

    public EntityNotFoundException(final Throwable cause) {
        super(cause);
    }
}
