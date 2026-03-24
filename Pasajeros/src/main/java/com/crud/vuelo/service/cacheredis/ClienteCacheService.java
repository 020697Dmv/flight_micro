package com.crud.vuelo.service.cacheredis;

import java.util.List;

import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
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
	public Cliente findById(Long id) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return clienteRepository.findById(id).orElse(null);
	}

	@Cacheable(value = "CLIENTE_LIST_CACHE", key = "'ALL'")
	public List<Cliente> findAll() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return clienteRepository.findAll();
	}

	@Caching(
			put = @CachePut(value = "CLIENTE_CACHE", key = "#cliente.id"),
			evict = @CacheEvict(value = "CLIENTE_LIST_CACHE", allEntries = true)
	)
	public Cliente put(Cliente cliente) {
		return cliente;
	}

	@Caching(evict = {
			@CacheEvict(value = "CLIENTE_CACHE", key = "#id"),
			@CacheEvict(value = "CLIENTE_LIST_CACHE", allEntries = true)
	})
	public void evict(Long id) {
	}
}
