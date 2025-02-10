package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.vuelo.models.Avion;
import com.crud.vuelo.models.Tiquetes;
import com.crud.vuelo.repository.TiquetesRepository;
import com.crud.vuelo.service.TiquetesService;

@Service
public class TiqueteServiceImpl  implements TiquetesService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private TiquetesRepository tiquetesRepository;

	@Override
	public List<Tiquetes> findAllTiquete() {
		
		List<Tiquetes> tiquetes = tiquetesRepository.findAll();

		return tiquetes;
	}

	@Override
	public ResponseEntity<Tiquetes> findTiquete(int id) {
		Optional<Tiquetes> optionalTiquete = tiquetesRepository.findById(id);

		if (optionalTiquete.isPresent()) {

			return new ResponseEntity<Tiquetes>(optionalTiquete.get(), HttpStatus.OK);

		} else {
			LOGGER.info("NO HAY INFORMACION DE UN TIQUETE CON ESTE ID: " + id);
			return ResponseEntity.noContent().build();

		}
	}

	@Override
	public Tiquetes saveTiquete(Tiquetes tiquetesNuevo) {
		List<Tiquetes> tiquetes = tiquetesRepository.findAll();
		

		boolean exists = tiquetes.stream().anyMatch(tiquete -> tiquete.getIdTiquete() == tiquetesNuevo.getIdTiquete());
		if (exists) {
			throw new IllegalArgumentException("El Tiquete con ese ID ya existe: " + tiquetesNuevo.getIdTiquete());
		}

		return tiquetesRepository.save(tiquetesNuevo);
	}

	@Override
	public ResponseEntity<Object> deleteTiquetes(int id) {
		if (!tiquetesRepository.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();

		}

		tiquetesRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<?> updateTiquete(Tiquetes tiquete, int id) {
		Optional<Tiquetes> tiquetes = tiquetesRepository.findById(id);

		if (!tiquetes.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		tiquetes.get().setValor(tiquete.getValor());
		tiquetes.get().setSilla(tiquete.getSilla());
		tiquetes.get().setClase(tiquete.getClase());
		tiquetes.get().setEquipaje(tiquete.getEquipaje());
		tiquetes.get().setVuelo(tiquete.getVuelo());
		tiquetes.get().setCliente(tiquete.getCliente());



		tiquetesRepository.save(tiquetes.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(tiquetesRepository.save(tiquetes.get()));
	}

}
