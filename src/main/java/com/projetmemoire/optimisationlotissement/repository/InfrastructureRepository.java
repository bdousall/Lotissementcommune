package com.projetmemoire.optimisationlotissement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetmemoire.optimisationlotissement.model.Infrastructure;

@Repository
public interface InfrastructureRepository extends JpaRepository<Infrastructure, Long>{
    @Query(value = "SELECT * FROM Infrastructure i WHERE ST_DWithin(i.geom, ST_GeomFromText(:point, 4326), :distance)", nativeQuery = true)
    List<Infrastructure> DistanceInf(@Param("point") String point, @Param("distance") double distance);

    @Query(value = "SELECT * FROM Infrastructure i WHERE ST_Within(i.geom, ST_GeomFromText(:polygon, 4326))", nativeQuery = true)
    List<Infrastructure> InfdansPolygon(@Param("polygon") String polygon);

}
