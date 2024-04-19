package com.projetmemoire.optimisationlotissement.model;

import java.util.HashSet;
import java.util.Set;

import org.locationtech.jts.geom.Polygon;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	private double superficie;
	private double longitude;
	private double latitude;
	
	@OneToMany(mappedBy="terrain",cascade= CascadeType.ALL,orphanRemoval=true)
	private Set<Parcelle> parcelles=new HashSet<>();
	@Column(columnDefinition="geometry(Polygon,4326)")
	private Polygon geom;

}
