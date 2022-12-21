package com.femsa.digital.backend.utileria.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * @author jesus.scruz
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}

}
