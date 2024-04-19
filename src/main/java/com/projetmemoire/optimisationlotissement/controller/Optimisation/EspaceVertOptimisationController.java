package com.projetmemoire.optimisationlotissement.controller.Optimisation;

import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetmemoire.optimisationlotissement.service.Algooptimisation.ServiceEspacevertOptimisationLotissement;

@RestController
@RequestMapping("/api/optimisation/espaces-verts")
public class EspaceVertOptimisationController {

    @Autowired
    private ServiceEspacevertOptimisationLotissement espacevertOptimisationService;

    @PostMapping("/optimiser")
    public ResponseEntity<Geometry> optimiserEspacesVerts(@RequestBody Geometry espaceVertActuel){
        Geometry resultat = espacevertOptimisationService.optimiserEspacesVerts(espaceVertActuel);
        return ResponseEntity.ok(resultat);
    }


}
