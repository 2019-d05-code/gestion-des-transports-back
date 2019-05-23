package dev.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler(value = { CollegueNonTrouveException.class })
	protected ResponseEntity<Object> gereCollegueNonTrouveException(RuntimeException ex, WebRequest request) {
		return ResponseEntity.status(404).body(ex.getMessage());
	}

	@ExceptionHandler(value = { CollegueDejaChauffeurException.class })
	protected ResponseEntity<Object> gereCollegueDejaChauffeurException(RuntimeException ex, WebRequest request) {
		return ResponseEntity.status(404).body(ex.getMessage());
	}
}
