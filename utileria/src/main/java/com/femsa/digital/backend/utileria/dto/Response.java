package com.femsa.digital.backend.utileria.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Response implements Serializable {

	/**
	 * @author jesus.scruz
	 */
	private static final long serialVersionUID = 2898039005406799695L;
	private String fecha;
	private Meta meta;
	private int error;
	private boolean estatus;

}
