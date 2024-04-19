package com.projetmemoire.optimisationlotissement.controller;

import java.util.List;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
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

import com.projetmemoire.optimisationlotissement.model.Terrain;
import com.projetmemoire.optimisationlotissement.service.imp.ServiceTerrainImp;

@RestController
@RequestMapping("/api/terrains")
public class TerrainController  {
	
	@Autowired
    private ServiceTerrainImp terrainService;

    @GetMapping
    public List<Terrain> getAllTerrains() {
        return terrainService.TotalTerrain();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable Long id) {
        Terrain terrain = terrainService.TerrainParId(id);
        return terrain != null ? ResponseEntity.ok(terrain) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Terrain> createTerrain(@RequestBody Terrain terrain) {
        Terrain createdTerrain = terrainService.EnregistrerTerrain(terrain);
        return ResponseEntity.ok(createdTerrain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Terrain> updateTerrain(@PathVariable Long id, @RequestBody Terrain terrainDetails) {
        Terrain updatedTerrain = terrainService.updateTerrain(terrainDetails, id);
        return ResponseEntity.ok(updatedTerrain);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Long id) {
        terrainService.deleteTerrain(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dansPolygon")
    public ResponseEntity<List<Terrain>> getTerrainsDansPolygon(@RequestParam String wktPolygon) {
        try {
            Geometry polygon = new WKTReader().read(wktPolygon);
            List<Terrain> terrains = terrainService.findParcellesWithin(polygon);
            return ResponseEntity.ok(terrains);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build(); // Error handling could be more specific
        }
    }

    @GetMapping("/presDePoint")
    public ResponseEntity<List<Terrain>> getTerrainsPresDePoint(@RequestParam String wktPoint, @RequestParam double distance) {
        try {
            Geometry point = new WKTReader().read(wktPoint);
            List<Terrain> terrains = terrainService.findParcellesNearPoint(point, distance);
            return ResponseEntity.ok(terrains);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build(); // Error handling could be more specific
        }
    }
	
	
	
}
