package com.crud.vuelo.before.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.vuelo.before.models.Aeropuerto;

public interface AeropuertoService {

	public List<Aeropuerto> findAllAeropuerto();

	public ResponseEntity<Aeropuerto> findAeropuerto(int id);

	public Aeropuerto saveAeropuerto(Aeropuerto aeropuertoNueva);

	public ResponseEntity<Object> deleteAeropuerto(int id);

	public ResponseEntity<?> updateAeropuerto(Aeropuerto newAeropuerto, int id);

}	
