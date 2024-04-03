package com.projetmemoire.optimisationlotissement.service;


import java.util.List;
import com.projetmemoire.optimisationlotissement.model.Terrain;



public interface serviceTerrain {
    Terrain EnregistrerTerrain(Terrain terrain);
    List<Terrain> TotalTerrain();
    Terrain TerrainParId(Long id);
    Terrain updateTerrain(Terrain terrain, Long id);
    void deleteTerrain(Long id);
}
