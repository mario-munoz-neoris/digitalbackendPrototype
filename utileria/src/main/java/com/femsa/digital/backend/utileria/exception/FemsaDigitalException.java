package com.femsa.digital.backend.utileria.exception;

public class FemsaDigitalException extends RuntimeException {

	/**
	 * @author jesus.scruz
	 */
	private static final long serialVersionUID = 9025222571173329304L;

	/**
	 * @author jesus.scruz
	 * @param mensaje
	 */
	public FemsaDigitalException(String mensaje) {
		super(mensaje);
	}

	public FemsaDigitalException(String mensaje, Throwable t) {
		super(mensaje, t);
	}

}
