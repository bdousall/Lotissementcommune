package com.projetmemoire.optimisationlotissement.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_projet;
	private String nom;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_parcelle")
	private Parcelle parcelle;


	

}
