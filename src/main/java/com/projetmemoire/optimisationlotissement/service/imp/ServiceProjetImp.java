package com.projetmemoire.optimisationlotissement.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetmemoire.optimisationlotissement.model.Projet;
import com.projetmemoire.optimisationlotissement.repository.ProjetRepository;
import com.projetmemoire.optimisationlotissement.service.ServiceProjet;



@Service
public class ServiceProjetImp implements ServiceProjet  {
	@Autowired
	private ProjetRepository projetRepository;
	
	@Override
	public Projet EnregistrerProjet(Projet projet) {
		return projetRepository.save(projet);
	}
	@Override
	public List<Projet> TotalProjet() {
		return projetRepository.findAll();	
	}
	
	@Override
	public Projet ProjetparId(Long id) {
		return projetRepository.findById(id).orElseThrow(()
				->new RuntimeException("Il n'existe pas de projet pour l'identifiant"+id));
	}
	
	@Override
	public Projet updateProjet(Projet projet, Long id) {
		Projet projetexistant=ProjetparId(id);
		projetexistant.setNom(projet.getNom());
		projetexistant.setDescription(projet.getDescription());
		projetexistant.setDateDebut(projet.getDateDebut());
		projetexistant.setDateFin(projet.getDateFin());
		return projetRepository.save(projetexistant);
	}
	
	@Override
	public void deleteProjet(Long id) {
		projetRepository.deleteById(id);
	}
}
