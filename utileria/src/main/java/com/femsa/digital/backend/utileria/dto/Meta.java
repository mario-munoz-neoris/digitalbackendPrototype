package com.femsa.digital.backend.utileria.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Meta implements Serializable {

	/**
	 * @author jesus.scruz
	 */
	private static final long serialVersionUID = -1347247210378206894L;
	private int status;
	private String msg;
	private int numError;
	private UUID transactionID;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
	private Timestamp timestamp;

}
