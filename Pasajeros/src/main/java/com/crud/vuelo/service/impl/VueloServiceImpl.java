package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.vuelo.entity.Cliente;
import com.crud.vuelo.entity.Vuelo;
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
		
		System.out.println(findCliente);
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

}
