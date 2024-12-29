package com.crud.vuelo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * Clase Avion
 * 
 * @author Danny Macias Vanegas
 *
 */
@Data
@Entity
@Table(name = "Avion")
public class Avion {
	
	
	/**
	* Variable idVuelo la cual es el identificador de la tabla Avion	 
	*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAvion;

	/**
	* Variable del modelo del Avion	 
	*/
	private String modelo;
	
	/**
	* Variable capacidad la cual es la capacidad del Avion	 
	*/
	private int capacidad;
	
	/**
	* Variable con la clave foranea de las Empresas creados	 
	*/
	@ManyToOne
	@JoinColumn(name="EmpresaFK")
	private Empresa empresa;
	
	
}
