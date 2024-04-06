package com.projetmemoire.optimisationlotissement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projetmemoire.optimisationlotissement.model.Projet;

import com.projetmemoire.optimisationlotissement.service.imp.ServiceProjetImp;


public class ProjetController {
	
	
	@Autowired
	private ServiceProjetImp projetS;
	
	@GetMapping
	public List<Projet> getAllProjet(){
		
		return projetS.TotalProjet();
		
	}
	
	@GetMapping ("/{id}")
	public Projet getProjetById(@PathVariable Long id) {
		return projetS.ProjetparId(id);
		
	}
	
	@PostMapping
	 public Projet createProjet(@RequestBody Projet projet) {
        return projetS.EnregistrerProjet(projet);
    }
	
	@PutMapping("/{id}")
	public Projet updatProjet(@PathVariable Long id, @RequestBody Projet projetDetail) {
		return projetS.updateProjet(projetDetail, id);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProjet(@PathVariable Long id){
		projetS.deleteProjet(id);
		return ResponseEntity.ok().build();
		
	}

}
