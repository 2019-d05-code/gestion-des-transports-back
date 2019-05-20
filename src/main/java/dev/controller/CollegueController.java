package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.ChauffeurVM;
import dev.domain.Collegue;
import dev.service.CollegueService;

@RestController
public class CollegueController {

	@Autowired
	CollegueService collegueService;

	@PostMapping(value = "/ajoutChauffeur")
	public ResponseEntity<Object> ajoutChauffeur(@RequestBody ChauffeurVM chauffeurVM) {
		Collegue collegue = collegueService.rechercherParMatricule(chauffeurVM.getMatricule());

		return ResponseEntity.status(HttpStatus.OK).body(collegue);
	}

}
