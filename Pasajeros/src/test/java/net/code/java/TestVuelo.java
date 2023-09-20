package net.code.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.crud.vuelo.entity.Cliente;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.repository.VueloRepository;
import com.crud.vuelo.service.impl.ClienteServiceImpl;
import com.crud.vuelo.service.impl.VueloServiceImpl;

public class TestVuelo {
	
	@Mock
	private ClienteRepository clienteRepository;

	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
	
	private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.openMocks(this);
		cliente= new Cliente();
		cliente.setId(1452);
		cliente.setNombre("Cristiano");
		cliente.setTelefono("342434");
		cliente.setEmail("cr7@");
		
	}
	
	@Test
	void findAll() {
	
		when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));
		
		
		assertNotNull(clienteRepository.findAll());
	
	}

	@Test
	void findAllTotal() {

		when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));

		assertEquals(1,clienteRepository.findAll().size());

	}


	@Test
	void findAllTotal2() {

		doNothing().when(clienteRepository).deleteById(1452);



		clienteRepository.deleteById(1452);

	}
}
