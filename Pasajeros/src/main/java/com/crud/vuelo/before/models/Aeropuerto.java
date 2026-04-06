package com.crud.vuelo.before.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
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
@Table(
	name = "Aeropuerto",
	indexes = {
		@Index(name = "idx_aeropuerto_ciudad", columnList = "ciudad")
	},
	uniqueConstraints = {
		@UniqueConstraint(name = "uk_aeropuerto_iata", columnNames = { "iata" }),
		@UniqueConstraint(name = "uk_aeropuerto_icao", columnNames = { "icao" })
	}
)
public class Aeropuerto {

	@Id
	@Column(name = "idAeropuerto")
	private Long idAeropuerto;

	@Column(length = 50)
	private String nombre;

	@Column(length = 80)
	private String ciudad;

	@Column(length = 120)
	private String direccion;

	@Column(length = 3)
	private String iata;

	@Column(length = 4)
	private String icao;

	@Column(length = 60)
	private String pais;

	@Column(length = 64)
	private String timezone;

}
