package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.vuelo.entity.Cliente;
import com.crud.vuelo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	

	@Override
	public List<Cliente> findAllCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> findCliente(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveCliente(Cliente clienteNuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCliente(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCliente(Cliente ClienteNew) {
		// TODO Auto-generated method stub
		return false;
	}

}
