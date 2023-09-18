package com.crud.vuelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
