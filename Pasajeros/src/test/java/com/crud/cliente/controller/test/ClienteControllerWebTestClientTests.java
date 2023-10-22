package com.crud.cliente.controller.test;

import com.crud.vuelo.entity.Cliente;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.hamcrest.Matchers.*;

@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteControllerWebTestClientTests {

	@Autowired
    private WebTestClient webTestClient;
	
	
	

	 @Test
	 @Order(1)
	 void testGuardarEmpleado(){
	        //given
		 Cliente cliente = Cliente.builder()
	                .id(366)
	                .nombre("Adrian")
	                .telefono("12547")
	                .email("aab@gmail.com")
	                .build();

	        //when
	        webTestClient.post().uri("http://localhost:8080/api/v1/crearCliente")
	                .contentType(MediaType.APPLICATION_JSON)
	                .bodyValue(cliente)
	                .exchange() 

	        //then
	                .expectStatus().isCreated()
	                .expectHeader().contentType(MediaType.APPLICATION_JSON)
	                .expectBody()
	                .jsonPath("$.id").isEqualTo(cliente.getId())
	                .jsonPath("$.nombre").isEqualTo(cliente.getNombre())
	                .jsonPath("$.telefono").isEqualTo(cliente.getTelefono())
	                .jsonPath("$.email").isEqualTo(cliente.getEmail());
	    }
	
	 	@Test
	    @Order(2)
	    void testObtenerClientePorId(){
	        webTestClient.get().uri("http://localhost:8080/api/v1/clienteId/366").exchange()
	                .expectStatus().isOk()
	                .expectHeader().contentType(MediaType.APPLICATION_JSON)
	                .expectBody()
	                .jsonPath("$.id").isEqualTo(366)
	                .jsonPath("$.nombre").isEqualTo("Adrian")
	                .jsonPath("$.telefono").isEqualTo("12547")
	                .jsonPath("$.email").isEqualTo("aab@gmail.com");;
	    }
	 	
	 	
	 
	 	  @Test
	 	  @Order(3)
	 	  void testListarClientes(){
	 	        webTestClient.get().uri("http://localhost:8080/api/v1/clientes").exchange()
	 	       .expectStatus().isOk()
               .expectHeader().contentType(MediaType.APPLICATION_JSON)
               .expectBodyList(Cliente.class)
               .consumeWith(response -> {
                   List<Cliente> empleados = response.getResponseBody();
                   Assertions.assertEquals(2,empleados.size());
                   Assertions.assertNotNull(empleados);
               });
	 	 }
	 	  
	 	 @Test
	     @Order(4)
	     void testActualizarCliente(){
	 		Cliente clienteActualizado = Cliente.builder()
	                 .nombre("Pepe")
	                 .telefono("1548")
	                 .email("ckk2@gmail.com")
	                 .build();

	         webTestClient.put().uri("http://localhost:8080//api/v1/actualizarCliente/366")
	                 .contentType(MediaType.APPLICATION_JSON)
	                 .bodyValue(clienteActualizado)
	                 .exchange() //envia el request

	                 //then
	                 .expectStatus().isOk()
	                 .expectHeader().contentType(MediaType.APPLICATION_JSON);
	     }
	 	 
	 	 @Test
	     @Order(5)
	     void testEliminarEmpleado(){
	         webTestClient.get().uri("http://localhost:8080/api/v1/clientes").exchange()
	                 .expectStatus().isOk()
	                 .expectHeader().contentType(MediaType.APPLICATION_JSON)
	                 .expectBodyList(Cliente.class)
	                 .hasSize(2);

	         webTestClient.delete().uri("http://localhost:8080/api/v1/eliminarCliente/366")
	                 .exchange()
	                 .expectStatus().isOk();

	         webTestClient.get().uri("http://localhost:8080/api/v1/clientes").exchange()
	                 .expectStatus().isOk()
	                 .expectHeader().contentType(MediaType.APPLICATION_JSON)
	                 .expectBodyList(Cliente.class)
	                 .hasSize(1);

	         webTestClient.get().uri("http://localhost:8080/api/empleados/1").exchange()
	                 .expectStatus().is4xxClientError();
	     }
}
	

