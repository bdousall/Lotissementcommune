package com.projetmemoire.optimisationlotissement.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terrain {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_terrain;
	private double supperficie;
	private double coordonnee;
	@OneToMany(mappedBy="terrain",cascade= CascadeType.ALL,orphanRemoval=true)
	private Set<Parcelle> parcelles=new HashSet<>();
	

}
