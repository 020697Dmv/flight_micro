package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.vuelo.models.Aeropuerto;
import com.crud.vuelo.models.Avion;
import com.crud.vuelo.repository.AvionRepository;
import com.crud.vuelo.service.AvionService;

@Service
public class AvionServiceImpl implements AvionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private AvionRepository avionRepository;

	@Override
	public List<Avion> findAllAvion() {

		List<Avion> aviones = avionRepository.findAll();

		return aviones;
	}

	@Override
	public ResponseEntity<Avion> findAvion(int id) {

		Optional<Avion> optionalAvion = avionRepository.findById(id);

		if (optionalAvion.isPresent()) {

			return new ResponseEntity<Avion>(optionalAvion.get(), HttpStatus.OK);

		} else {
			LOGGER.info("NO HAY INFORMACION DE UN AVION CON ESTE ID: " + id);
			return ResponseEntity.noContent().build();

		}
	}

	@Override
	public Avion saveAvion(Avion avionNueva) {

		List<Avion> aviones = avionRepository.findAll();

		boolean exists = aviones.stream().anyMatch(avion -> avion.getIdAvion() == avionNueva.getIdAvion());
		if (exists) {
			throw new IllegalArgumentException("El Avion con ese ID ya existe: " + avionNueva.getIdAvion());
		}

		return avionRepository.save(avionNueva);
	}

	@Override
	public ResponseEntity<Object> deleteAvion(int id) {

		if (!avionRepository.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();

		}

		avionRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<?> updateAvion(Avion newAvion, int id) {
		Optional<Avion> avion = avionRepository.findById(id);

		if (!avion.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		avion.get().setModelo(newAvion.getModelo());
		avion.get().setCapacidad(newAvion.getCapacidad());
		avion.get().setEmpresa(newAvion.getEmpresa());

		avionRepository.save(avion.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(avionRepository.save(avion.get()));
	}

}
