package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Annonce;
import dev.service.CollegueService;

@RestController
@CrossOrigin
@RequestMapping("/collaborateur")
public class CollegueController {

	@Autowired
	private CollegueService collegueService;

	@PostMapping("/annonces/creer")
	public ResponseEntity<?> creerAnnonce(@RequestBody Annonce annonce) {
		collegueService.creerAnnonce(annonce);
		return ResponseEntity.ok().build();
	}

}