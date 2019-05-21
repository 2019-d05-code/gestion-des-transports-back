package dev.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler(value = { CollegueNonTrouveException.class })
	protected ResponseEntity<Object> handleConflict1(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Collegue non trouvé";
		return ResponseEntity.status(404).body(bodyOfResponse);
	}

	@ExceptionHandler(value = { CollegueDejaChauffeurException.class })
	protected ResponseEntity<Object> handleConflict2(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Le Collegue a déjà le role de chauffeur";
		return ResponseEntity.status(404).body(bodyOfResponse);
	}
}
