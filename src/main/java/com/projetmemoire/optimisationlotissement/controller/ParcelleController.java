package com.projetmemoire.optimisationlotissement.controller;

import com.projetmemoire.optimisationlotissement.model.Parcelle;
import com.projetmemoire.optimisationlotissement.service.imp.ServiceParcelleImp;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
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
    public ResponseEntity<Parcelle> getParcelleById(@PathVariable Long id) {
        Parcelle parcelle = parcelleService.ParcelleParId(id);
        return parcelle != null ? ResponseEntity.ok(parcelle) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Parcelle> createParcelle(@RequestBody Parcelle parcelle) {
        Parcelle createdParcelle = parcelleService.EnregistrerParcelle(parcelle);
        return ResponseEntity.ok(createdParcelle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parcelle> updateParcelle(@PathVariable Long id, @RequestBody Parcelle parcelleDetails) {
        Parcelle updatedParcelle = parcelleService.updateParcelle(parcelleDetails, id);
        return ResponseEntity.ok(updatedParcelle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParcelle(@PathVariable Long id) {
        parcelleService.deleteParcelle(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dansPolygon")
    public ResponseEntity<List<Parcelle>> findParcellesWithin(@RequestBody String wktPolygon) throws ParseException {
        Geometry polygon = new WKTReader().read(wktPolygon);
        List<Parcelle> parcelles = parcelleService.findParcellesWithin(polygon);
        return ResponseEntity.ok(parcelles);
    }

    @GetMapping("/presDePoint")
    public ResponseEntity<List<Parcelle>> findParcellesNearPoint(@RequestParam String wktPoint,
            @RequestParam double distance) throws ParseException {
        Geometry point = new WKTReader().read(wktPoint);
        List<Parcelle> parcelles = parcelleService.findParcellesNearPoint(point, distance);
        return ResponseEntity.ok(parcelles);
    }
}
