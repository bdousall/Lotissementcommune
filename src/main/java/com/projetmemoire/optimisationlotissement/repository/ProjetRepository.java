package com.projetmemoire.optimisationlotissement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetmemoire.optimisationlotissement.model.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>{

}
