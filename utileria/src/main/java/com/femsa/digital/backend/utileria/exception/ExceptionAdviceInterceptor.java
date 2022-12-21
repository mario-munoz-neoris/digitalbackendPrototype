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
	 * @author jesus.scruz
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> globalExceptionHandler(Exception ex, WebRequest request) {
		MetaDTO meta = new MetaDTO();
		meta.setMsg(ex.getMessage());
		ResponseDTO respuesta = new ResponseDTO();
		respuesta.setMeta(meta);
		return new ResponseEntity<>(respuesta, null, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}
