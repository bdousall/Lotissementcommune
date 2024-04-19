package com.projetmemoire.optimisationlotissement.service.imp;

import java.util.List;

import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projetmemoire.optimisationlotissement.model.Terrain;
import com.projetmemoire.optimisationlotissement.repository.TerrainRepository;
import com.projetmemoire.optimisationlotissement.service.serviceTerrain;

@Service
public class ServiceTerrainImp implements serviceTerrain{
    @Autowired
    private TerrainRepository terrainRepository;
    @Override
    public Terrain EnregistrerTerrain(Terrain terrain){
        return terrainRepository.save(terrain);
    }

    @Override
    public List<Terrain> TotalTerrain(){
        return terrainRepository.findAll();
    }
    @Override
    public Terrain TerrainParId(Long id){
        return terrainRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Ce terrain n'existe pas"));
    }

    @Override
    public Terrain updateTerrain(Terrain terrain, Long id){
        Terrain terrainExistant=TerrainParId(id);
        terrainExistant.setSuperficie(terrain.getSuperficie());
        terrainExistant.setLatitude(terrain.getLatitude());
        terrainExistant.setLongitude(terrain.getLongitude());
        return terrainRepository.save(terrainExistant);
    }

    @Override
    public void deleteTerrain(Long id){
        terrainRepository.deleteById(id);
    }
     @Override
    public List<Terrain> findParcellesWithin(Geometry polygon){
        return terrainRepository.TerraindanslePolygon(polygon);
    }

    @Override
    public List<Terrain> findParcellesNearPoint(Geometry point, double distance){
        return terrainRepository.DistanceTerrain(point, distance);
    }




}