package com.femsa.digital.backend.domain.exceptions;

/**
 * List of code to management
 */
public enum ErrorCodes {

    BAD_REQUEST_CODE("Solicitud incorrecta"),

    NOT_FOUND_CODE("No se encontró %s"),

    SERVICE_UNAVAILABLE_CODE("Error al %s"),

    UNAUTHORIZED_CODE("La solicitud no se autenticó %s");

    private final String message;

    ErrorCodes(final String message) {

        this.message = message;

    }

    public String message() {

        return message;

    }

}
