package com.projetmemoire.optimisationlotissement.repository;

import java.util.List;

import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetmemoire.optimisationlotissement.model.Parcelle;


@Repository
public interface ParcelleRepository extends JpaRepository<Parcelle, Long> {
   
        @Query("SELECT p FROM Parcelle p WHERE within(p.geom, :polygon) = true")
        List<Parcelle> ParcelledanslePolygon(@Param("polygon") Geometry polygon);
    
        @Query("SELECT p FROM Parcelle p WHERE dwithin(p.geom, ?1, ?2) = true")
        List<Parcelle> DistanceParcelle(Geometry point, double distance);
}
