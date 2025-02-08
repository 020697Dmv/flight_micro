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
import com.crud.vuelo.models.Empresa;
import com.crud.vuelo.repository.AeropuertoRepository;
import com.crud.vuelo.service.AeropuertoService;

@Service
public class AeropuertoServiceImpl implements AeropuertoService {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

	
	@Autowired
	private  AeropuertoRepository aeropuertoRepository;
	
	@Override
	public List<Aeropuerto> findAllAeropuerto() {
		// TODO Auto-generated method stub
		
		List<Aeropuerto> aeropuertos=aeropuertoRepository.findAll();
				
		return aeropuertos;
	}

	@Override
	public ResponseEntity<Aeropuerto> findAeropuerto(int id) {

		Optional<Aeropuerto> optionalAeropuerto= aeropuertoRepository.findById(id);
		
		if(optionalAeropuerto.isPresent()) {
			
			return new ResponseEntity<Aeropuerto>(optionalAeropuerto.get(), HttpStatus.OK);

			
		}else {
			LOGGER.info("NO HAY INFORMACION DE UN AEROPUERTO CON ESTE ID: " + id);
			return ResponseEntity.noContent().build();
			
		}		
	}

	@Override
	public Aeropuerto saveAeropuerto(Aeropuerto aeropuertoNueva) {

		List <Aeropuerto> aeropuertos= aeropuertoRepository.findAll();
		
		boolean exists= aeropuertos.stream()
					.anyMatch(aeropuerto-> aeropuerto.getIdAeropuerto()== aeropuertoNueva.getIdAeropuerto());		
		if (exists) {
	        throw new IllegalArgumentException("El Aeropuerto con ese ID ya existe: " + aeropuertoNueva.getIdAeropuerto());
	    }
		
		return aeropuertoRepository.save(aeropuertoNueva);
	}

	@Override
	public ResponseEntity<Object> deleteAeropuerto(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateAeropuerto(Aeropuerto newAeropuerto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
