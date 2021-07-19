package com.crud.vuelo.service;

import java.util.List;

import com.crud.vuelo.entity.Vuelo;

/**
 * En esta clase estan declarados los servicios que pueden ser utilizados
 * 
 * @author Danny Macias Vanegas
 *
 */
public interface VueloService {
	
	public List<Vuelo> findAllVuelo();


}
