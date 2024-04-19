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
    private ServiceProjetImp projetService;

    @GetMapping
    public List<Projet> getAllProjets() {
        return projetService.TotalProjet();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Projet projet = projetService.ProjetparId(id);
        return projet != null ? ResponseEntity.ok(projet) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        Projet createdProjet = projetService.EnregistrerProjet(projet);
        return ResponseEntity.ok(createdProjet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet projetDetails) {
        Projet updatedProjet = projetService.updateProjet(projetDetails, id);
        return ResponseEntity.ok(updatedProjet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
        return ResponseEntity.ok().build();
    }

}
