package com.api.api_biblioteca.exception;

public class UnauthorizedAccessException extends RuntimeException {

    // Constructor que pasa el mensaje al constructor de la superclase
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}