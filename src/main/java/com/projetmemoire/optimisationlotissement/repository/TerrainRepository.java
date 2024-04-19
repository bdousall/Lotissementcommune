package com.projetmemoire.optimisationlotissement.repository;

import java.util.List;

import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.projetmemoire.optimisationlotissement.model.Terrain;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
    @Query("SELECT t FROM Terrain t WHERE within(t.geom, :polygon) = true")
    List<Terrain> TerraindanslePolygon(@Param("polygon") Geometry polygon);

    @Query("SELECT t FROM Terrain t WHERE dwithin(t.geom, :point, :distance) = true")
    List<Terrain>DistanceTerrain(@Param("point") Geometry point, @Param("distance") double distance);

}
