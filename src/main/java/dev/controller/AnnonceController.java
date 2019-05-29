package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.AnnonceDTO;
import dev.exception.CollegueNonTrouveException;
import dev.exception.EmptyRepositoryException;
import dev.service.AnnonceService;

@RestController
@CrossOrigin
@RequestMapping
public class AnnonceController {

	@Autowired
	private AnnonceService annonceService;

	@PostMapping("/annonce/creer")
	public ResponseEntity<AnnonceDTO> creerAnnonce(@RequestBody AnnonceDTO annonceDTO) throws EmptyRepositoryException {
		AnnonceDTO annonceDTOCree = annonceService.creerAnnonce(annonceDTO);
		return ResponseEntity.ok(annonceDTOCree);
	}

	@ExceptionHandler(EmptyRepositoryException.class)
	public ResponseEntity<String> gereEmptyRepositoryException(EmptyRepositoryException ere) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ere.getMessage());
	}
	
	@ExceptionHandler(CollegueNonTrouveException.class)
	public ResponseEntity<String> gereEmptyRepositoryException(CollegueNonTrouveException cnte) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(cnte.getMessage());
	}
	


}