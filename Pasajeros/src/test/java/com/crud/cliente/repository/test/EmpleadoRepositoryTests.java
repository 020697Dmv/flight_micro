package com.crud.cliente.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Cliente.class)
public class EmpleadoRepositoryTests {

	
	
	@Autowired
	private ClienteRepository clienteRepository;

	
	private Cliente cliente;
	
	 @BeforeEach
	 void setup(){
		 cliente = Cliente.builder()
				 	.id(1596321458)
	                .nombre("Christian")
	                .telefono("Ramirez")
	                .email("c1@gmail.com")
	                .build();
	 }
	 
	 @DisplayName("Test para guardar un cliente")
	 @Test
	 void testGuardarCliente(){

		 Cliente cliente1 = Cliente.builder()
				 	.id(1522447)
	                .nombre("Pepe")
	                .telefono("Lopez")
	                .email("p12@gmail.com")
	                .build();

		 Cliente clienteGuardado = clienteRepository.save(cliente1);

	        assertThat(clienteGuardado).isNotNull();
	        assertThat(clienteGuardado.getId()).isGreaterThan(0);
	    }
	 
	 
	 @DisplayName("Test para listar a los clientes")
	 @Test
	 void testListarClientes(){

		 Cliente cliente1 = Cliente.builder()
				 	.id(1540)
	                .nombre("Julen")
	                .telefono("Oliva")
	                .email("j2@gmail.com")
	                .build();
	        clienteRepository.save(cliente1);
	        clienteRepository.save(cliente1);

	        List<Cliente> listaClientes = clienteRepository.findAll();

	        assertThat(listaClientes).isNotNull();
	        assertThat(listaClientes.size()).isEqualTo(2);
	    }
	 
	 @DisplayName("Test para obtener un cliente por ID")
	 @Test
	 void testObtenerClientePorId(){
		 clienteRepository.save(cliente);

		 Cliente clienteBD = clienteRepository.findById(cliente.getId()).get();

	        assertThat(clienteBD).isNotNull();
	    }
	 
	 @DisplayName("Test para actualizar un cliente")
	 @Test
	 void testActualizarCliente(){
		 clienteRepository.save(cliente);

	        Cliente clienteGuardado = clienteRepository.findById(cliente.getId()).get();
	        clienteGuardado.setEmail("dannymv@gmail.com");
	        clienteGuardado.setNombre("Danny");
	        clienteGuardado.setTelefono("318297");
	        Cliente clienteActualizado = clienteRepository.save(clienteGuardado);

	        assertThat(clienteActualizado.getEmail()).isEqualTo("dannymv@gmail.com");
	        assertThat(clienteActualizado.getNombre()).isEqualTo("Danny");
	    }

	    @DisplayName("Test para eliminar un cliente")
	    @Test
	    void testEliminarCliente(){
	    	clienteRepository.save(cliente);

	    	clienteRepository.deleteById(cliente.getId());
	        Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getId());

	        assertThat(clienteOptional).isEmpty();
	    }

}
