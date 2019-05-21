package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CollegueVM;
import dev.service.CollegueService;

@RestController
public class CollegueController {

	@Autowired
	CollegueService collegueService;

	@PatchMapping(value = "ajoutChauffeur/{matricule}")
	public ResponseEntity<Object> ajoutChauffeur(@PathVariable long matricule) {
		CollegueVM collegueVM = collegueService.modifierRole(matricule);
		return ResponseEntity.status(HttpStatus.OK).body(collegueVM);
	}

	@GetMapping(value = "/chauffeur")
	public List<CollegueVM> recupChauffeur() {
		return collegueService.recupColleChauffeur();
	}

}
