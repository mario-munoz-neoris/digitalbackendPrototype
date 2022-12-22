package com.femsa.digital.backend.utileria.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @author jesus.scruz
	 * @param mensaje
	 */
	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}

}
