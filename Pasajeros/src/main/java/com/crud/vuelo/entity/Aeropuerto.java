package com.crud.vuelo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
