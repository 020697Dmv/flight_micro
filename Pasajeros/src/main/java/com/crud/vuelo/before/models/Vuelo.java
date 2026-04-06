package com.crud.vuelo.before.models;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Vuelo")
public class Vuelo {

	@Id
	private Long idVuelo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	private int capacidad;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime hora;

	@ManyToOne
	@JoinColumn(name = "EmpresaFK")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "aeropuertoFK", referencedColumnName = "idAeropuerto")
	private Aeropuerto aeropuerto;

	@ManyToOne
	@JoinColumn(name = "aeropuertoDestinoFK", referencedColumnName = "idAeropuerto")
	private Aeropuerto aeropuertoDestino;

	@ManyToOne
	@JoinColumn(name = "avionFK", referencedColumnName = "idAvion")
	private Avion avion;

}
