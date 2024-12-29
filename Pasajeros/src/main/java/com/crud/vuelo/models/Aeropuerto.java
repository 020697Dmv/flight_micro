package com.crud.vuelo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * Clase Aeropuerto
 * 
 * @author Danny Macias Vanegas
 *
 */
@Data
@Entity
@Table(name = "Aeropuerto")
public class Aeropuerto {
	
	/**
	* Variable idAeropuerto la cual es el identificador de la tabla Aeropuerto	 
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAeropuerto;
	
	/**
	* Variable nombre la cual es el nombre del Aeropuerto	 
	*/
	@Column(length = 50)
	private String nombre;

	/**
	* Variable ciudad la cual es la ciudad donde esta el Aeropuerto	 
	*/
	private String ciudad;

	/**
	* Variable direccion la cual es la direccion donde esta el Aeropuerto	 
	*/
	private String direccion;

		
}
