package com.projetmemoire.optimisationlotissement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetmemoire.optimisationlotissement.model.Terrain;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {

}
