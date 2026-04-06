package com.crud.vuelo.before.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Avion", uniqueConstraints = { @UniqueConstraint(name = "uk_avion_matricula", columnNames = { "matricula" }) })
public class Avion {

	@Id
	@Column(name = "idAvion")
	private Long idAvion;

	@Column(length = 30)
	private String modelo;

	private int capacidad;

	@Column(length = 12)
	private String matricula;

	@ManyToOne
	@JoinColumn(name = "empresa_fk")
	private Empresa empresa;

}
