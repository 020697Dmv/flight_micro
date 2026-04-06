package com.crud.vuelo.before.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Empresa")
public class Empresa {

	@Id
	@Column(name = "idEmpresa")
	private Long idEmpresa;

	@Column(length = 50)
	private String nombre;

	@Column(length = 20)
	private String telefono;

	@Column(length = 255)
	private String paginaWeb;

	@Column(length = 3)
	private String iata;

	@Column(length = 4)
	private String icao;

}
