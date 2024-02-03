package com.crud.vuelo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.models.Vuelo;

/**
 * En esta clase estan declarados los servicios que pueden ser utilizados
 * 
 * @author Danny Macias Vanegas
 *
 */
public interface VueloService {
	
	public List<Vuelo> findAllVuelo();

	public ResponseEntity<Vuelo> findVuelo(int id);
	
	public ResponseEntity saveVuelo(Vuelo vueloNuevo);

	public ResponseEntity<?> updateVuelo(Vuelo vueloNew, int idVuelo);

	public ResponseEntity<Object> deleteVuelo(int idVuelo);

	
}
