package com.projetmemoire.optimisationlotissement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Infrastructure {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_infrastructure;
	private String type;
	private double sup_infrastructure;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_parcelle")
	private Parcelle parcelle;

}
