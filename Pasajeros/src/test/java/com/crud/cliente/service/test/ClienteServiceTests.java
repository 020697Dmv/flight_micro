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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.service.impl.ClienteServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTests {

	
	  @Mock
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
		
	
	
	@Test
	@DisplayName("saveCliente debe guardar un cliente cuando no existe")
	void testSaveCliente_WhenDoesNotExist() {

	    // Arrange
	    Cliente nuevo = Cliente.builder()
	            .id(1)
	            .nombre("Juan")
	            .email("juan@test.com")
	            .build();

	    // La BD está vacía
	    given(clienteRepository.findAll()).willReturn(Collections.emptyList());

	    // Simulamos respuesta del repositorio al guardar
	    given(clienteRepository.save(nuevo)).willReturn(nuevo);

	    // Act
	    Cliente resultado = clienteServiceImpl.saveCliente(nuevo);

	    // Assert
	    assertThat(resultado).isNotNull();
	    assertThat(resultado.getId()).isEqualTo(1);

	    verify(clienteRepository, times(1)).findAll();
	    verify(clienteRepository, times(1)).save(nuevo);
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
	
	@Test
	@DisplayName("Test para obtener un cliente por ID (existe)")
	void testObtenerClientePorIdExiste() {

	    // Arrange
	    cliente.setId(10);
	    given(clienteRepository.findById(10)).willReturn(Optional.of(cliente));

	    // Act
	    ResponseEntity<Cliente> respuesta = clienteServiceImpl.findCliente(10);

	    // Assert
	    assertThat(respuesta).isNotNull();
	    assertThat(respuesta.getStatusCode()).isEqualTo(HttpStatus.OK);
	    assertThat(respuesta.getBody()).isNotNull();
	    assertThat(respuesta.getBody().getId()).isEqualTo(10);

	    verify(clienteRepository, times(1)).findById(10);
	}

	@Test
	@DisplayName("Test para obtener un cliente por ID que no existe (204)")
	void testObtenerClientePorIdNoExiste() {

	    // Arrange
	    given(clienteRepository.findById(99)).willReturn(Optional.empty());

	    // Act
	    ResponseEntity<Cliente> respuesta = clienteServiceImpl.findCliente(99);

	    // Assert
	    assertThat(respuesta).isNotNull();
	    assertThat(respuesta.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	    assertThat(respuesta.getBody()).isNull(); // 204 no tiene body

	    verify(clienteRepository, times(1)).findById(99);
	}

	
	@DisplayName("Test para actualizar un Cliente")
	@Test
	void testActualizarCliente() {

	    // Arrange
	    Cliente clienteExistente = Cliente.builder()
	            .id(85)
	            .nombre("Old Name")
	            .email("old@gmail.com")
	            .telefono("0000")
	            .build();

	    // Mock: findById debe devolver un cliente existente
	    given(clienteRepository.findById(85)).willReturn(Optional.of(clienteExistente));

	    // Mock: save() devolverá el cliente actualizado
	    given(clienteRepository.save(any(Cliente.class))).willReturn(cliente);

	    // Datos nuevos
	    cliente.setEmail("chr2@gmail.com");
	    cliente.setNombre("Christian Raul");

	    // Act
	    ResponseEntity<?> response = clienteServiceImpl.updateCliente(cliente, 85);

	    // Assert
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	    assertThat(response.getBody()).isInstanceOf(Cliente.class);

	    Cliente actualizado = (Cliente) response.getBody();
	    assertThat(actualizado.getEmail()).isEqualTo("chr2@gmail.com");
	    assertThat(actualizado.getNombre()).isEqualTo("Christian Raul");

	    // Opcional: validar que save se haya llamado
	    verify(clienteRepository, times(1)).save(any(Cliente.class));
	}


	@DisplayName("Test para eliminar un cliente exitosamente")
	@Test
	void testEliminarCliente() {

	    // Arrange
	    int clienteId = 1;

	    // Mock: el cliente sí existe
	    given(clienteRepository.findById(clienteId)).willReturn(Optional.of(new Cliente()));

	    // Mock: deleteById no hace nada
	    willDoNothing().given(clienteRepository).deleteById(clienteId);

	    // Act
	    ResponseEntity<Object> response = clienteServiceImpl.deleteCliente(clienteId);

	    // Assert
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	    verify(clienteRepository, times(1)).deleteById(clienteId);
	}
	
	@DisplayName("Test para eliminar cliente que no existe")
	@Test
	void testEliminarClienteNoEncontrado() {

	    // Arrange
	    int clienteId = 1;

	    // Mock: no existe el cliente
	    given(clienteRepository.findById(clienteId)).willReturn(Optional.empty());

	    // Act
	    ResponseEntity<Object> response = clienteServiceImpl.deleteCliente(clienteId);

	    // Assert
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

	    // deleteById NO debe ejecutarse
	    verify(clienteRepository, never()).deleteById(anyInt());
	}

	
	 	
	  @Test
	    @DisplayName("Test: findAllCliente debe devolver una lista de clientes")
	    void testFindAllCliente_ReturnsClients() {

	        List<Cliente> listaClientes = List.of(cliente);

	        given(clienteRepository.findAll()).willReturn(listaClientes);

	        List<Cliente> resultado = clienteServiceImpl.findAllCliente();

	        assertThat(resultado).isNotNull();
	        assertThat(resultado).hasSize(1);
	        assertThat(resultado.get(0).getId()).isEqualTo(123);

	        verify(clienteRepository).findAll();
	    }

	    @Test
	    @DisplayName("Test: findAllCliente debe devolver una lista vacía")
	    void testFindAllCliente_ReturnsEmptyList() {

	        given(clienteRepository.findAll()).willReturn(Collections.emptyList());

	        List<Cliente> resultado = clienteServiceImpl.findAllCliente();

	        assertThat(resultado).isEmpty();

	        verify(clienteRepository).findAll();
	    }
	 
}
