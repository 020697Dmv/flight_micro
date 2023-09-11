package com.crud.vuelo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.vuelo.entity.Vuelo;
import com.crud.vuelo.repository.VueloRepository;
import com.crud.vuelo.service.VueloService;

@Service
public class VueloServiceImpl implements VueloService{
	
	@Autowired
	private VueloRepository vueloRepository;

	@Override
	public List<Vuelo> findAllVuelo() {

		return this.vueloRepository.findAll();
	}

}
