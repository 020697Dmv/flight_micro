package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.vuelo.models.Empresa;
import com.crud.vuelo.repository.EmpresaRepository;
import com.crud.vuelo.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public List<Empresa> findAllEmpresas() {
		
		List<Empresa> empresas = empresaRepository.findAll();
		return empresas;
	}

	@Override
	public ResponseEntity<Empresa> findEmpresa(int id) {
		
		int idEmpresa = id;

		Optional<Empresa> optionalEmpresa = empresaRepository.findById(idEmpresa);
		if (optionalEmpresa.isPresent()) {

			return new ResponseEntity<Empresa>(optionalEmpresa.get(), HttpStatus.OK);

		} else {
			LOGGER.info("NO HAY INFORMACION DE UNA EMPRESA CON ESTE ID: " + id);
			return ResponseEntity.noContent().build();

		}
	}

	@Override
	public Empresa saveEmpresa(Empresa empresaNueva) {
		
		List<Empresa> empresas = empresaRepository.findAll();

	    boolean exists = empresas.stream()
	        .anyMatch(empresa -> empresa.getIdEmpresa() == empresaNueva.getIdEmpresa());

	    if (exists) {
	        throw new IllegalArgumentException("La empresa con ese ID ya existe: " + empresaNueva.getIdEmpresa());
	    }

	    return empresaRepository.save(empresaNueva);
	}

	@Override
	public ResponseEntity<Object> deleteEmpresa(int id) {
		
		if (!empresaRepository.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();

		}

		empresaRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<?> updateEmpresa(Empresa newEmpresa, int id) {
		
		Optional<Empresa> empresa = empresaRepository.findById(id);

		if (!empresa.isPresent()) {
			System.out.println("editar");
			return ResponseEntity.notFound().build();
		}

		empresa.get().setPaginaWeb(newEmpresa.getPaginaWeb());
		empresa.get().setNombre(newEmpresa.getNombre());
		empresa.get().setTelefono(newEmpresa.getTelefono());

		empresaRepository.save(empresa.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa.get()));
		
	}
	

}
