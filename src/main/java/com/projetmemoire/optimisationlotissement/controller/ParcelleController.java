package com.projetmemoire.optimisationlotissement.controller;

import com.projetmemoire.optimisationlotissement.model.Parcelle;
import com.projetmemoire.optimisationlotissement.service.imp.ServiceParcelleImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcelles")
public class ParcelleController {

    @Autowired
    private ServiceParcelleImp parcelleService;

    @GetMapping
    public List<Parcelle> getAllParcelles() {
        return parcelleService.TotalParcelle();
    }

    @GetMapping("/{id}")
    public Parcelle getParcelleById(@PathVariable Long id) {
        return parcelleService.ParcelleParId(id);
    }

    @PostMapping
    public Parcelle createParcelle(@RequestBody Parcelle parcelle) {
        return parcelleService.EnregistrerParcelle(parcelle);
    }

    @PutMapping("/{id}")
    public Parcelle updateParcelle(@PathVariable Long id, @RequestBody Parcelle parcelleDetails) {
        return parcelleService.updateParcelle(parcelleDetails, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParcelle(@PathVariable Long id) {
        parcelleService.deleteParcelle(id);
        return ResponseEntity.ok().build();
    }
}
