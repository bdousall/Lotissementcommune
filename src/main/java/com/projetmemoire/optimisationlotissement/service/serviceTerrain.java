package com.projetmemoire.optimisationlotissement.service;


import java.util.List;

import org.locationtech.jts.geom.Geometry;


import com.projetmemoire.optimisationlotissement.model.Terrain;



public interface serviceTerrain {
    Terrain EnregistrerTerrain(Terrain terrain);
    List<Terrain> TotalTerrain();
    Terrain TerrainParId(Long id);
    Terrain updateTerrain(Terrain terrain, Long id);
    void deleteTerrain(Long id);
    public List<Terrain> findParcellesWithin(Geometry polygon);
    public List<Terrain> findParcellesNearPoint(Geometry point, double distance);
}
