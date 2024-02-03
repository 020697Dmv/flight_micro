package com.crud.cliente.service.test;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.service.impl.ClienteServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTests {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
	
	private Cliente cliente;
	
	@BeforeEach
    void setup(){
		cliente = Cliente.builder()
                .id(123)
                .nombre("Christian")
                .telefono("Ramirez")
                .email("c1@gmail.com")
                .build();
    }
	
	
	@DisplayName("Test para guardar un cliente")
	@Test
	void testGuardarCliente() {

		given(clienteRepository.findByemail(cliente.getEmail())).willReturn(Optional.empty());
		given(clienteRepository.save(cliente)).willReturn(cliente);

		Cliente clienteGuardado = clienteRepository.save(cliente);

		assertThat(clienteGuardado).isNotNull();
	}
	
	@DisplayName("Test para listar a los empleados")
    @Test
    void testListarEmpleados(){
        Cliente cliente1 = Cliente.builder()
                .id(2)
                .nombre("Julian")
                .telefono("78484")
                .email("jul@gmail.com")
                .build();
        given(clienteRepository.findAll()).willReturn(List.of(cliente,cliente1));

        List<Cliente> clientes = clienteRepository.findAll();

        assertThat(clientes).isNotNull();
        assertThat(clientes.size()).isEqualTo(2);
    }
	
	@DisplayName("Test para obtener un cliente por ID")
	@Test
	void testObtenerClientePorId() {
		given(clienteRepository.findById(10)).willReturn(Optional.of(cliente));

		Cliente clienteGuardado = clienteServiceImpl.findCliente(cliente.getId()).getBody();

		assertThat(clienteGuardado).isNotNull();
	}
	
	 @DisplayName("Test para actualizar un Cliente")
	    @Test
	    void testActualizarCliente(){
	        //given
	        given(clienteRepository.save(cliente)).willReturn(cliente);
	        cliente.setEmail("chr2@gmail.com");
	        cliente.setNombre("Christian Raul");

	        //when
	        ResponseEntity<?> clienteActualizado  = clienteServiceImpl.updateCliente(cliente,85);

	        //then
	        assertThat(clienteActualizado.getEmail()).isEqualTo("chr2@gmail.com");
	        assertThat(clienteActualizado.getNombre()).isEqualTo("Christian Raul");
	    }

	    @DisplayName("Test para eliminar un empleado")
	    @Test
	    void testEliminarEmpleado(){
	        //given
	        int empleadoId = 1;
	        willDoNothing().given(clienteRepository).deleteById(empleadoId);

	        //when
	        clienteRepository.deleteById(empleadoId);

	        //then
	        verify(clienteRepository,times(1)).deleteById(empleadoId);
	    }
	

}
