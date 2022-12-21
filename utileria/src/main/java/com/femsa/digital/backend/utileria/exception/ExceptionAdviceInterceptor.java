package com.femsa.digital.backend.utileria.exception;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.femsa.digital.backend.utileria.dto.MetaDTO;
import com.femsa.digital.backend.utileria.dto.ResponseDTO;

@ControllerAdvice
public class ExceptionAdviceInterceptor {

	/**
	 * Firma de metodo que se dispara desde los clientes que lo invocan lanzando una
	 * {@link Exception} personalizada y un mensaje de tipo {@link String}. Devuelve
	 * un objeto {@link ResponseDTO} con el detalle {@link MetaDTO} en formato JSON
	 * 
	 * @author jesus.scruz
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	public ResponseEntity<ResponseDTO> notFoundException(ResourceNotFoundException ex, WebRequest request) {
		ResponseDTO respuesta = new ResponseDTO();
		MetaDTO meta = new MetaDTO();
		meta.setMsg(ex.getMessage());
		meta.setDescripcion("Para fines de desarrollo");
		meta.setNumError(100);
		meta.setStatus(HttpStatus.NOT_FOUND.value());
		meta.setTransactionID(UUID.randomUUID());
		meta.setTimestamp(new Timestamp(System.currentTimeMillis()));
		respuesta.setMeta(meta);
		return new ResponseEntity<>(respuesta, null, HttpStatus.NOT_FOUND.value());
	}

	/**
	 * Firma de metodo que se dispara desde los clientes que lo invocan lanzando una
	 * {@link Exception} generica y un mensaje de tipo {@link String}. Devuelve un
	 * objeto {@link ResponseDTO} y con el detalle {@link MetaDTO} en formato JSON
	 * 
	 * @author jesus.scruz
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> globalExceptionHandler(Exception ex, WebRequest request) {
		ResponseDTO respuesta = new ResponseDTO();
		MetaDTO meta = new MetaDTO();
		meta.setMsg(ex.getMessage());
		meta.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		meta.setTransactionID(UUID.randomUUID());
		meta.setTimestamp(new Timestamp(System.currentTimeMillis()));
		respuesta.setMeta(meta);
		return new ResponseEntity<>(respuesta, null, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}
