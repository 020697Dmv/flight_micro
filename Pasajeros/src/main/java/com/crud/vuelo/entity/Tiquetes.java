package com.crud.vuelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase Tiquetes
 * 
 * @author Danny Macias Vanegas
 *
 */
@Entity
@Table(name = "Tiquetes")
public class Tiquetes {
	
	/**
	* Variable idVuelo la cual es el identificador de la tabla Vuelo	 
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVuelo;
	
	/**
	* Variable con el valor del Tiquete	 
	*/
	private String valor;
	
	/**
	* Variable con la silla del Tiquete	 
	*/
	private String silla;
	
	/**
	* Variable con la clase del Tiquete	 
	*/
	private String clase;
	
	/**
	* Variable del equipaje del Tiquete	 
	*/
	private int equipaje;
	
	/**
	* Variable con la clave foranea de los Vuelos creados	 
	*/
	@ManyToOne
	@JoinColumn(name="vueloFK")
	private Vuelo vuelo;

	/**
	* Variable con la clave foranea de los Cliente creados	 
	*/
	@ManyToOne
	@JoinColumn(name="clienteFK")
	private Cliente cliente;

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getSilla() {
		return silla;
	}

	public void setSilla(String silla) {
		this.silla = silla;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getEquipaje() {
		return equipaje;
	}

	public void setEquipaje(int equipaje) {
		this.equipaje = equipaje;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
