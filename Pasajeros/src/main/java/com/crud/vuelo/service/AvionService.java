package com.crud.vuelo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.vuelo.models.Avion;

public interface AvionService {
	
	public List<Avion> findAllAvion();

	public ResponseEntity<Avion> findAvion(int id);

	public Avion saveAvion(Avion AvionNueva);

	public ResponseEntity<Object> deleteAvion(int id);

	public ResponseEntity<?> updateAvion(Avion newAvion, int id);

}
