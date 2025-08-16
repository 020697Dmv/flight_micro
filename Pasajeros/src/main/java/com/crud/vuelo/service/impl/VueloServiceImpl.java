package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.vuelo.models.Vuelo;
import com.crud.vuelo.repository.VueloRepository;
import com.crud.vuelo.service.VueloService;

@Service
public class VueloServiceImpl implements VueloService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private VueloRepository vueloRepository;

	@Override
	public List<Vuelo> findAllVuelo() {

		Optional<Vuelo> findCliente= this.vueloRepository.findByidVuelo(148);
		
		Optional<Integer> findAeropuerto= this.vueloRepository.findByCapacidad("1478");
		
		return this.vueloRepository.findAll();
	}

	@Override
	public ResponseEntity<Vuelo> findVuelo(int id) {
		
		int idVuelo = id;
		Optional<Vuelo> optionalVuelo = vueloRepository.findById(idVuelo);
		if (optionalVuelo.isPresent()) {

			return new ResponseEntity<Vuelo>(optionalVuelo.get(), HttpStatus.OK);

		} else {
			LOGGER.info("NO HAY INFORMACION DE UN CLIENTE CON ESTE ID: " + id);
			return ResponseEntity.noContent().build();

		}
		
	}

	@Override
	public ResponseEntity<?> updateVuelo(Vuelo vueloNew, int idVuelo) {
		Optional<Vuelo> vuelo = vueloRepository.findById(idVuelo);

		if (!vuelo.isPresent()) {
			System.out.println("editar");
			return ResponseEntity.notFound().build();
		}

		vuelo.get().setCapacidad(vueloNew.getCapacidad());
		vuelo.get().setFecha(vueloNew.getFecha());
		vuelo.get().setHora(vueloNew.getHora());

		vueloRepository.save(vuelo.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(vueloRepository.save(vuelo.get()));
	}

	@Override
	public ResponseEntity<Object> deleteVuelo(int idVuelo) {
		if (!vueloRepository.findById(idVuelo).isPresent()) {
			return ResponseEntity.notFound().build();

		}

		vueloRepository.deleteById(idVuelo);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity saveVuelo(Vuelo vueloNuevo) {
		List<Vuelo> vuelos = vueloRepository.findAll();

		for (Vuelo vuelo2 : vuelos) {

			if (vuelo2.getIdVuelo() == vueloNuevo.getIdVuelo()) {

				return new ResponseEntity<>("\"mensaje\" : \"El Cliente con identificaciï¿½n  " + vueloNuevo.getIdVuelo()
						+ " ya tiene una id igual a la ingresada\"", HttpStatus.BAD_REQUEST);

			}

		}

		vueloRepository.save(vueloNuevo);

		return new ResponseEntity<>("Vuelo creado", HttpStatus.CREATED);
	}
	
	

}
