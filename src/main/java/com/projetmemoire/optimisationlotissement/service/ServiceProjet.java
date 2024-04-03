package com.projetmemoire.optimisationlotissement.service;

import java.util.List;

import com.projetmemoire.optimisationlotissement.model.Projet;

public interface ServiceProjet {
	Projet EnregistrerProjet(Projet projet);
	List<Projet> TotalProjet();
	Projet ProjetparId(Long id);
	Projet updateProjet(Projet projet, Long id);
	void deleteProjet(Long id);
}
