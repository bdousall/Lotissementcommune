package com.projetmemoire.optimisationlotissement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetmemoire.optimisationlotissement.model.Parcelle;


@Repository
public interface ParcelleRepository extends JpaRepository<Parcelle, Long> {

}
