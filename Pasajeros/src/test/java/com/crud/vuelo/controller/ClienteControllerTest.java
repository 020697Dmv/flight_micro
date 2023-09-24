package com.crud.vuelo.controller;

import com.crud.vuelo.entity.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ClienteControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Order(1)
    void getClientes()  {
    	
    	ResponseEntity<Cliente[]> clientes= testRestTemplate.getForEntity("http://localhost:8080/api/v1/clientes",Cliente[].class);

    	 List<Cliente> ClienteList = Arrays.asList(clientes.getBody());
    	 
         assertEquals(10,ClienteList.size());

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
                .id(22228)
                .nombre("111")
                .email("11@kl")
                .telefono("3434")
                .build();
         	
        	
        ResponseEntity<Cliente>  respuesta = testRestTemplate.postForEntity("http://localhost:8080/api/v1/crearCliente",cliente,Cliente.class);


            System.out.println(respuesta.getBody());

            System.out.println(respuesta.getStatusCode());

            assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

    }

    @Test
    void actualizarCliente() {
    }

    @Test
    void eliminarCliente() {
    }
}