package com.crud.vuelo.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import com.crud.vuelo.entity.Cliente;
import com.crud.vuelo.service.ClienteService;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest
public class ClienteControllerTests {
	
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@MockBean
	private ClienteService clienteService;
	
	 @Test
	 void testGuardarCliente() throws Exception {
	        //given
		 Cliente cliente = Cliente.builder()
	                .id(1)
	                .nombre("Christian")
	                .telefono("Ramirez")
	                .email("c1@gmail.com")
	                .build();
	        given(clienteService.saveCliente(any(Cliente.class)))
	                .willAnswer((invocation) -> invocation.getArgument(0));

	        //when
	        ResultActions response = mockMvc.perform(post("/api/v1/crearCliente")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(cliente)));

	        //then
	        response.andDo(print())
	                .andExpect(status().isCreated())
	                .andExpect(jsonPath("$.nombre",is(cliente.getNombre())))
	                .andExpect(jsonPath("$.telefono",is(cliente.getTelefono())))
	                .andExpect(jsonPath("$.email",is(cliente.getEmail())));
	    }
	 
	 @Test
	 void testListarClientes() throws Exception{
	        //given
	        List<Cliente> listaClientes = new ArrayList<>();
	        listaClientes.add(Cliente.builder().id(98).nombre("Christian").telefono("Ramirez").email("c1@gmail.com").build());
	        listaClientes.add(Cliente.builder().id(12).nombre("Gabriel").telefono("Ramirez").email("g1@gmail.com").build());
	        listaClientes.add(Cliente.builder().id(34).nombre("Julen").telefono("Ramirez").email("cj@gmail.com").build());
	        listaClientes.add(Cliente.builder().id(54).nombre("Biaggio").telefono("Ramirez").email("b1@gmail.com").build());
	        listaClientes.add(Cliente.builder().id(67).nombre("Adrian").telefono("Ramirez").email("a@gmail.com").build());
	        given(clienteService.findAllCliente()).willReturn(listaClientes);

	        //when
	        ResultActions response = mockMvc.perform(get("/api/clientes"));

	        //then
	        response.andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(jsonPath("$.size()",is(listaClientes.size())));
	    }

	  @Test
	    void testObtenerClientePorId() throws Exception{
	        //given
		  

	        int empleadoId = 8888;
	        Cliente cliente = Cliente.builder()
	                .nombre("Haydee")
	                .telefono("31785")
	                .email("HAYDE@")
	                .build();
	        
			  ResponseEntity<Cliente> responseEntity = ResponseEntity.ok(cliente);

	        given(clienteService.findCliente(empleadoId)).willReturn(responseEntity);

	        //when
	        ResultActions response = mockMvc.perform(get("/api/v1/clienteId/{id}",empleadoId));

	        //then
	        response.andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(jsonPath("$.nombre",is(cliente.getNombre())))
	                .andExpect(jsonPath("$.telefono",is(cliente.getTelefono())))
	                .andExpect(jsonPath("$.email",is(cliente.getEmail())));
	    }
	  
	   @Test
	    void testActualizarCliente() throws Exception{
	        //given
	        int clienteId = 8888;
	        Cliente clienteGuardado = Cliente.builder()
	                .nombre("Andrea")
	                .telefono("Lopez")
	                .email("c1@gmail.com")
	                .build();

	        Cliente clienteActualizado = Cliente.builder()
	                .nombre("Raul")
	                .telefono("Ramirez")
	                .email("c231@gmail.com")
	                .build();
	        
			  ResponseEntity<Cliente> responseEntity = ResponseEntity.ok(clienteGuardado);


	        given(clienteService.findCliente(clienteId)).willReturn((responseEntity));
	        given(clienteService.updateCliente(clienteActualizado,clienteId))
	                .willAnswer((invocation) -> invocation.getArgument(0));

	        //when
	        ResultActions response = mockMvc.perform(put("//api/v1/actualizarCliente/{id}",clienteId)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(clienteActualizado)));

	        //then
	        response.andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(jsonPath("$.nombre",is(clienteActualizado.getNombre())))
	                .andExpect(jsonPath("$.telefono",is(clienteActualizado.getTelefono())))
	                .andExpect(jsonPath("$.email",is(clienteActualizado.getEmail())));
	    }
	   
	   @Test
	    void testEliminarEmpleado() throws Exception{
	        //given
	        int clienteId = 8888;
	        willDoNothing().given(clienteService).deleteCliente(clienteId);

	        //when
	        ResultActions response = mockMvc.perform(delete("//api/v1/eliminarCliente/{id}",clienteId));

	        //then
	        response.andExpect(status().isOk())
	                .andDo(print());
	    }

	

}