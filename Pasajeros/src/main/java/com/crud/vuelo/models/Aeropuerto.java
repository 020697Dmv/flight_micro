package com.crud.vuelo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "Aeropuerto")
public class Aeropuerto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAeropuerto;
	
		@Column(length = 50)
	private String nombre;

	
	private String ciudad;

	
	private String direccion;

		
}
