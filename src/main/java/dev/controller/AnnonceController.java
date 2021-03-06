package dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.AnnonceDTO;
import dev.exception.CollegueNonTrouveException;
import dev.exception.EmptyRepositoryException;
import dev.service.AnnonceService;

@RestController
@CrossOrigin
@RequestMapping("/annonce")
public class AnnonceController {

	@Autowired
	private AnnonceService annonceService;

	@PostMapping("/creer")
	public ResponseEntity<AnnonceDTO> creerAnnonce(@RequestBody AnnonceDTO annonceDTO) throws EmptyRepositoryException {
		AnnonceDTO annonceDTOCree = annonceService.creerAnnonce(annonceDTO);
		return ResponseEntity.ok(annonceDTOCree);
	}

	@GetMapping("/liste")
	public ResponseEntity<List<AnnonceDTO>> listerSesAnnonces(@RequestParam String email) {
		List<AnnonceDTO> annoncesDTO;
		try {
			annoncesDTO = annonceService.listerSesAnnonces(email);
		} catch (EmptyRepositoryException e) {
			return ResponseEntity.ok(new ArrayList<AnnonceDTO>());
		}
		return ResponseEntity.ok(annoncesDTO);
	}

	@GetMapping("/liste/all-current")
	public ResponseEntity<List<AnnonceDTO>> listerToutesAnnoncesEnCours() {
		List<AnnonceDTO> annoncesDTO;
		try {
			annoncesDTO = annonceService.listerToutesAnnoncesEnCours();
		} catch (EmptyRepositoryException e) {
			return ResponseEntity.ok(new ArrayList<AnnonceDTO>());
		}
		return ResponseEntity.ok(annoncesDTO);
	}

	@ExceptionHandler(EmptyRepositoryException.class)
	public ResponseEntity<String> gereEmptyRepositoryException(EmptyRepositoryException ere) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ere.getMessage());
	}

	@ExceptionHandler(CollegueNonTrouveException.class)
	public ResponseEntity<String> gereCollegueNonTrouveException(CollegueNonTrouveException cnte) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(cnte.getMessage());
	}

}