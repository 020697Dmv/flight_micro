package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.vuelo.entity.Cliente;
import com.crud.vuelo.entity.Vuelo;
import com.crud.vuelo.repository.VueloRepository;
import com.crud.vuelo.service.VueloService;

@Service
public class VueloServiceImpl implements VueloService{
	
	@Autowired
	private VueloRepository vueloRepository;

	@Override
	public List<Vuelo> findAllVuelo() {

		Optional<Vuelo> findCliente= this.vueloRepository.findByidVuelo(148);
		
		System.out.println(findCliente);
		return this.vueloRepository.findAll();
	}

}
