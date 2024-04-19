package com.projetmemoire.optimisationlotissement.controller;

import java.util.List;


import org.locationtech.jts.geom.Point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetmemoire.optimisationlotissement.model.Infrastructure;
import com.projetmemoire.optimisationlotissement.service.imp.ServiceInfrastructureImp;

@RestController
@RequestMapping("/api/infrastructures")
public class InfrastructureController {

    @Autowired
    private ServiceInfrastructureImp infrastructureService;

    @GetMapping
    public List<Infrastructure> getAllInfrastructures() {
        return infrastructureService.TotalInf();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infrastructure> getInfrastructureById(@PathVariable Long id) {
        Infrastructure infrastructure = infrastructureService.InfParId(id);
        return infrastructure != null ? ResponseEntity.ok(infrastructure) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Infrastructure> createInfrastructure(@RequestBody Infrastructure infrastructure) {
        Infrastructure createdInfrastructure = infrastructureService.Enregistrerinf(infrastructure);
        return ResponseEntity.ok(createdInfrastructure);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Infrastructure> updateInfrastructure(@PathVariable Long id, @RequestBody Infrastructure infrastructureDetails) {
        Infrastructure updatedInfrastructure = infrastructureService.updateInf(infrastructureDetails, id);
        return ResponseEntity.ok(updatedInfrastructure);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfrastructure(@PathVariable Long id) {
        infrastructureService.deleteInfrastructure(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/distance")
    public List<Infrastructure> findInfrastructuresWithinDistance(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double distance) {
        Point point = infrastructureService.createPoint(latitude, longitude);
        return infrastructureService.findInfrastructuresWithinDistance(point, distance);
    }

    @PostMapping("/dansPolygon")
    public List<Infrastructure> findInfrastructuresByPolygon(@RequestBody String polygonWKT) {
        return infrastructureService.findInfrastructuresByPolygon(polygonWKT);
    }

}
