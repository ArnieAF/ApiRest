package com.api.api_biblioteca.exception;

public class ResourceNotFoundException extends RuntimeException {

    // Constructor que pasa el mensaje al constructor de la superclase
    public ResourceNotFoundException(String message) {
        super(message);
    }
}