package com.femsa.digital.backend.domain.exceptions;

public class ConsultasExceptions extends RuntimeException{
    private final String message;

    public ConsultasExceptions(String mensaje){
        this.message = mensaje;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
