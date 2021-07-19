package com.crud.vuelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase Avion
 * 
 * @author Danny Macias Vanegas
 *
 */
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

	/**
	* Setters y getters
	*/
	public int getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
	
}
