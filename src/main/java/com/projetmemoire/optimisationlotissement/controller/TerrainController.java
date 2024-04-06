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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetmemoire.optimisationlotissement.model.Terrain;
import com.projetmemoire.optimisationlotissement.service.imp.ServiceTerrainImp;

@RestController
@RequestMapping("/api/terrains")
public class TerrainController  {
	
	@Autowired
	private ServiceTerrainImp terrainS;
	
	@GetMapping
	public List<Terrain> getAllTerrains(){
		
		return terrainS.TotalTerrain();
		
	}
	
	@GetMapping ("/{id}")
	public Terrain getTerrainById(@PathVariable Long id) {
		return terrainS.TerrainParId(id);
		
	}
	
	@PostMapping
	 public Terrain createTerrain(@RequestBody Terrain terrain) {
        return terrainS.EnregistrerTerrain(terrain);
    }
	
	@PutMapping("/{id}")
	public Terrain updaTerrain(@PathVariable Long id, @RequestBody Terrain terrainDetail) {
		return terrainS.updateTerrain(terrainDetail,id);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTerrain(@PathVariable Long id){
		terrainS.deleteTerrain(id);
		return ResponseEntity.ok().build();
		
	}
	
	
	
}
