package com.projetmemoire.optimisationlotissement.model;


import java.util.HashSet;
import java.util.Set;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parcelle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_parcelle;
	private double sup_parcelle;
	private String statut;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_terrain")
	private Terrain terrain;
	
	@OneToMany(mappedBy="parcelle",cascade=CascadeType.ALL, orphanRemoval=true)
	@EqualsAndHashCode.Exclude
	private Set<Projet> projets=new HashSet<>();
	
	@OneToMany(mappedBy="parcelle",cascade=CascadeType.ALL, orphanRemoval=true)
	@EqualsAndHashCode.Exclude
	private Set<Infrastructure> infrastructures=new HashSet<>();

	@Column(columnDefinition = "geometry(Polygon,4326)")
	private Polygon geom;

	@Column(columnDefinition = "geometry(Point,4326)")
	private Point emplacement;


}
