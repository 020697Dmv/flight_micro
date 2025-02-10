package com.crud.vuelo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.vuelo.models.Tiquetes;

public interface TiquetesService {
	
	public List<Tiquetes> findAllTiquete();

	public ResponseEntity<Tiquetes> findTiquete(int id);

	public Tiquetes saveTiquete(Tiquetes tiquetesNuevo);

	public ResponseEntity<Object> deleteTiquetes(int id);

	public ResponseEntity<?> updateTiquete(Tiquetes tiqueteNew, int id);

}
