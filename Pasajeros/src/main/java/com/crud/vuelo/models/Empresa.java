package com.crud.vuelo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase Empresa
 * 
 * @author Danny Macias Vanegas
 *
 */
@Data
@Entity
@Table(name = "Empresa")
public class Empresa {
	
	/**
	* Variable idEmpresa la cual es el identificador de la tabla Empresa	 
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpresa;

	/**
	* Variable nombre la cual es el nombre de la Empresa	 
	*/
	@Column(length = 50)
	private String nombre;

	/**
	* Variable telefono la cual es el telefono de la Empresa 
	*/
	private int telefono;
	
	/**
	* Variable paginaWeb la cual es la pagina web de la Empresa  
	*/
	private String paginaWeb;

	/**
	* Setters y getters
	*/
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	
	

}
