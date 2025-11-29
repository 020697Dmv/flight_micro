package com.crud.vuelo.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crud.vuelo.controller.ClienteController;
import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.service.ClienteService;
import com.crud.vuelo.service.JwtService;

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

@WebMvcTest(ClienteController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ClienteControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteService clienteService;

	@MockBean
	private JwtService jwtService;

	private List<Cliente> clientes;

	@BeforeEach
	void setUp() {
		clientes = List.of(Cliente.builder().id(1).nombre("Juan").email("juan@gmail.com").build(),
				Cliente.builder().id(2).nombre("Luis").email("luis@gmail.com").build());
	}

	@Test
	@WithMockUser(username = "testuser", roles = { "USER" })
	void testGetClientes_Exitoso() throws Exception {
		given(clienteService.findAllCliente()).willReturn(clientes);

		mockMvc.perform(get("/api/v1/clientes").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()").value(2)).andExpect(jsonPath("$[0].nombre").value("Juan"));
	}

	@Test
	void testGetClientes_NoContent() throws Exception {
		given(clienteService.findAllCliente()).willReturn(List.of());

		mockMvc.perform(get("/api/v1/clientes")).andExpect(status().isOk()).andExpect(jsonPath("$.size()").value(0));
	}

	@Test
	void testGetClientes_PorId() throws Exception {

		Cliente cliente = clientes.get(0);

		given(clienteService.findCliente(1)).willReturn(ResponseEntity.ok(cliente));

		mockMvc.perform(get("/api/v1/clienteId/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.nombre").value("Juan"))
				.andExpect(jsonPath("$.email").value("juan@gmail.com"));
	}

	@Test
	@DisplayName("Debe crear un cliente y retornar 200")
	void testCrearCliente() throws Exception {

		Cliente cliente = new Cliente(1, "danny", "3172874", "danny@gmail.com");

		given(clienteService.saveCliente(any(Cliente.class))).willReturn(cliente);

		mockMvc.perform(post("/api/v1/crearCliente").contentType(MediaType.APPLICATION_JSON).content("""
				    {
				      "id": 1,
				      "nombre": "danny",
				      "telefono": "3172874",
				      "email": "danny@gmail.com"
				    }
				""")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nombre").value("danny")).andExpect(jsonPath("$.telefono").value("3172874"))
				.andExpect(jsonPath("$.email").value("danny@gmail.com"));
	}
	
	@Test
	@DisplayName("Debe actualizar el cliente")
	void testActualizarCliente() throws Exception {

	    Cliente cliente = new Cliente(1, "danny", "318297", "dmv@gmail.com");

	    given(clienteService.updateCliente(any(Cliente.class), eq(1)))
	    .willReturn(ResponseEntity.status(HttpStatus.CREATED).body(cliente));

		
		mockMvc.perform(put("/api/v1/actualizarCliente/1")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("""
		            {
		              "id": 1,
		              "nombre": "danny",
		              "telefono": "3172874",
		              "email": "danny@gmail.com"
		            }
		        """))
		        .andExpect(status().isCreated()) // <-- cambia a isCreated()
		        .andExpect(jsonPath("$.id").value(1))
		        .andExpect(jsonPath("$.nombre").value("danny"))
		        .andExpect(jsonPath("$.telefono").value("318297"))
		        .andExpect(jsonPath("$.email").value("dmv@gmail.com"));
	}
	
	@Test
	@DisplayName("Debe eliminar el cliente cuando existe")
	void testEliminarCliente_Exito() throws Exception {

	    // Mock: el servicio devuelve 200 OK
	    given(clienteService.deleteCliente(1))
	            .willReturn((ResponseEntity<Object>) ResponseEntity.ok().build());

	    mockMvc.perform(delete("/api/v1/eliminarCliente/1"))
	            .andExpect(status().isOk());
	}

	
	@Test
	@DisplayName("Debe retornar 404 cuando el cliente NO existe")
	void testEliminarCliente_NoExiste() throws Exception {

	    // Mock: el servicio devuelve NOT FOUND
	    given(clienteService.deleteCliente(999))
	            .willReturn((ResponseEntity<Object>) ResponseEntity.notFound().build());

	    mockMvc.perform(delete("/api/v1/eliminarCliente/999"))
	            .andExpect(status().isNotFound());
	}






}