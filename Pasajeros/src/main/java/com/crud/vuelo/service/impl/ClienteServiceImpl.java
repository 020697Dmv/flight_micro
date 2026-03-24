package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.service.ClienteService;
import com.crud.vuelo.service.cacheredis.ClienteCacheService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);


	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteCacheService clienteCacheService;

 
    @Override
	public List<Cliente> findAllCliente() {
		return clienteCacheService.findAll();
	}

	@Override
	public ResponseEntity<Cliente> findCliente(Long id) {
		Cliente cliente = clienteCacheService.findById(id);
		if (cliente != null) {
			return new ResponseEntity<>(cliente, HttpStatus.OK);

		} else {
			LOGGER.info("NO HAY INFORMACION DE UN CLIENTE CON ESTE ID: " + id);
			return ResponseEntity.noContent().build();

		}
	}

	@Override
	public Cliente saveCliente(Cliente clienteNuevo) {
		if (clienteNuevo.getId() != null && clienteRepository.existsById(clienteNuevo.getId())) {
	        throw new IllegalArgumentException("El Cliente con esa ID ya existe: " + clienteNuevo.getId());
	    }
		Cliente saved = clienteRepository.save(clienteNuevo);
		clienteCacheService.put(saved);
		return saved;
	}

	@Override
	public ResponseEntity<Object> deleteCliente(Long id) {
		if (!clienteRepository.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();

		}

		clienteRepository.deleteById(id);
		clienteCacheService.evict(id);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Cliente> updateCliente(Cliente clienteUpdate, Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		cliente.get().setEmail(clienteUpdate.getEmail());
		cliente.get().setNombre(clienteUpdate.getNombre());
		cliente.get().setTelefono(clienteUpdate.getTelefono());

		Cliente saved = clienteRepository.save(cliente.get());
		clienteCacheService.put(saved);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);

	}	
	
}
