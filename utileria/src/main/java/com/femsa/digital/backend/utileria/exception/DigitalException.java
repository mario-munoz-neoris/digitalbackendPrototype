package com.femsa.digital.backend.utileria.exception;

import com.femsa.digital.backend.utileria.dto.Meta;
import com.femsa.digital.backend.utileria.dto.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DigitalException extends Exception {

	public static final Response respuesta = new Response();

	/**
	 * @author jesus.scruz
	 */
	private static final long serialVersionUID = 2215065829240046565L;

	/**
	 * Firma de metodo para el manejo de excepciones
	 * 
	 * @author jesus.scruz
	 * @param message
	 * @param numErr
	 * @param status
	 */
	public DigitalException(String message, int numErr, int status) {
		super(message);
		Meta meta = new Meta();
		meta.setMsg(message);
		meta.setNumError(numErr);
		meta.setStatus(status);
		respuesta.setMeta(meta);
		log.info("respuesta=>{}", respuesta);
	}

	/**
	 * Firma de metodo para el manejo de excepciones y su traza de evento
	 * 
	 * @author jesus.scruz
	 * @param message
	 * @param numErr
	 * @param status
	 * @param t
	 */
	public DigitalException(String message, int numErr, int status, Throwable t) {
		super(message);
		Meta meta = new Meta();
		meta.setMsg(message);
		meta.setNumError(numErr);
		meta.setStatus(status);
		respuesta.setMeta(meta);
		log.info("respuesta=>{}, throws=>{}", respuesta, t.getCause());
	}

	/**
	 * @author jesus.scruz
	 * @return String mensaje
	 */
	public String getMensaje() {
		return respuesta.getMeta().getMsg();
	}

	/**
	 * @author jesus.scruz
	 * @return int Numero de error
	 */
	public int getNumError() {
		return respuesta.getMeta().getNumError();
	}

	/**
	 * @author jesus.scruz
	 * @return int Estatus de la respuesta
	 */
	public int getStatus() {
		return respuesta.getMeta().getStatus();
	}

}
