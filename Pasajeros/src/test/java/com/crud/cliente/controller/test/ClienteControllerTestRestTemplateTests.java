package com.crud.cliente.controller.test;

import com.crud.vuelo.entity.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.models.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;



import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ClienteControllerTestRestTemplateTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Order(1)
    void getClientes()  {
    	
    	ResponseEntity<Cliente[]> clientes= testRestTemplate.getForEntity("http://localhost:8080/api/v1/clientes",Cliente[].class);

    	 List<Cliente> ClienteList = Arrays.asList(clientes.getBody());
    	 
     //    assertEquals(14,ClienteList.size());

         assertEquals(HttpStatus.OK,clientes.getStatusCode());

    }

    @Test
    @Order(2)
    void getClienteId() {
    	
        ResponseEntity<Cliente> respuesta = testRestTemplate.getForEntity("http://localhost:8080/api/v1/clienteId/52525",Cliente.class);
        
        Cliente cliente = respuesta.getBody();
        
        assertEquals(HttpStatus.OK,respuesta.getStatusCode());



    }

    @Test
    @Order(3)
    void crearCliente() {
    	
    	Cliente cliente= Cliente.builder()
                .id(193)
                .nombre("REPO")
                .email("PARADE@kl")
                .telefono("31827")
                .build();
         	
        	
        ResponseEntity<Cliente>  respuesta = testRestTemplate.postForEntity("http://localhost:8080/api/v1/crearCliente",cliente,Cliente.class);


            System.out.println(respuesta.getBody());

            System.out.println(respuesta.getStatusCode());

            assertEquals(HttpStatus.OK, respuesta.getStatusCode());
            
            assertEquals(MediaType.APPLICATION_JSON,respuesta.getHeaders().getContentType());

    }

    @Test
    @Order(4)
    void actualizarCliente() {
    	
    	URI uri = new URI("http://localhost:8080/api/v1/actualizarCliente");
    	
    	Cliente cliente= new Cliente();
    	
    	cliente.setEmail("defe@gma");
    	cliente.setTelefono("927");
    	cliente.setNombre("gma");

    	
    	HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

	

		HttpEntity<Cliente> httpEntity = new HttpEntity<>(cliente,headers);

		ResponseEntity<Cliente> responseEntity = testRestTemplate.exchange(uri, HttpMethod.PUT, httpEntity,void.class);

		System.out.println("Status Code : " + responseEntity.getStatusCode());
		System.out.println(responseEntity.getBody());
        assertEquals(HttpStatus.CREATED,respuesta.getStatusCode());

    }

    @Test
    void eliminarCliente() {
    	
    	Map<String,Integer> pathVariables = new HashMap<>();
        pathVariables.put("id",8888);
        ResponseEntity<Void> exchange = testRestTemplate.exchange("http://localhost:8080/api/v1/eliminarCliente/{id}", HttpMethod.DELETE,null,Void.class,pathVariables);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());

    }
}