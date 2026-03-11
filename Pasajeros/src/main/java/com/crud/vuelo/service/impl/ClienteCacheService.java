package com.crud.vuelo.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.repository.ClienteRepository;

@Service
public class ClienteCacheService {

	private final ClienteRepository clienteRepository;

	public ClienteCacheService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Cacheable(value = "CLIENTE_CACHE", key = "#id")
	public Cliente findById(int id) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return clienteRepository.findById(id).orElse(null);
	}

	@CachePut(value = "CLIENTE_CACHE", key = "#cliente.id")
	public Cliente put(Cliente cliente) {
		return cliente;
	}

	@CacheEvict(value = "CLIENTE_CACHE", key = "#id")
	public void evict(int id) {
	}
}
