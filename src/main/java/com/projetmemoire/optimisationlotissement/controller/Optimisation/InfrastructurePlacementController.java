package com.projetmemoire.optimisationlotissement.controller.Optimisation;

import java.util.List;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetmemoire.optimisationlotissement.model.Infrastructure;
import com.projetmemoire.optimisationlotissement.service.Algooptimisation.ServiceInfrastructurePlacement;

@RestController
@RequestMapping("api/optimisation/infrastructures")
public class InfrastructurePlacementController {

    @Autowired
    private ServiceInfrastructurePlacement infrastructurePlacementService;

    @PostMapping("/optimiser")
    public ResponseEntity<List<Infrastructure>> optimiserPlacement(@RequestBody OptimisationRequest request) {
        List<Infrastructure> resultats = infrastructurePlacementService
                .optimiserPlacementInfrastructures(request.getInfrastructures(), request.getPointsDInteret());
        return ResponseEntity.ok(resultats);
    }

    @PostMapping("/placement-optimal")
    public ResponseEntity<Infrastructure> calculerEmplacementOptimal(@RequestParam String type,
            @RequestParam String wktZone) {
        try {
            Geometry zone = new WKTReader().read(wktZone);
            Infrastructure resultat = infrastructurePlacementService.calculerEmplacementOptimal(zone, type);
            return ResponseEntity.ok(resultat);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private static class OptimisationRequest {
        private List<Infrastructure> infrastructures;
        private List<Point> pointsDInteret;

        public List<Infrastructure> getInfrastructures() {
            return infrastructures;
        }

        public List<Point> getPointsDInteret() {
            return pointsDInteret;
        }
    }

}
