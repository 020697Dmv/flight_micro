package net.code.java;

import com.crud.vuelo.entity.Cliente;
import com.crud.vuelo.entity.Vuelo;
import com.crud.vuelo.repository.VueloRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@DataJpaTest
public class SpringBootMockito {

	@Autowired    
    private Cliente pruebas;

		
	@Test
    public void testGuardarProducto() {
        Cliente cliente = new Cliente(523, "David", "5214", "david@");

//        Cliente productoGuardado = pruebas.(cliente);
//
//        // Agregar aserciones para verificar que el producto se haya guardado correctamente
//        assertNotNull(productoGuardado.getId());
//        assertEquals("Producto de prueba", productoGuardado.getNombre());
    }

	/**
	 * Metodo donde se crea un nuevo CLiente, luego se verifica si fue creado en la
	 * Base de Datos
	 */
//	/*
//	@Test
//	@Rollback(false)
//	public void getClienteTest() {
//
//		Cliente cliente = new Cliente(523, "David", "5214", "david@");
//
//		Cliente savedCliente = clienteRepository.save(cliente);
//
//		assertNotNull(savedCliente,"Exito");
//
//	}
//
//	/**
//	 * Metodo donde se actualiza un CLiente,
//	 *  luego se verifica si fue editado en la Base de Datos
//	 */
//	@Test
//	@Rollback(false)
//	public void testUpdateCliente() {
//
//		int id = 4533;
//		Cliente cliente = new Cliente(id, "Andrea", "85633", "Andrea@");
//		cliente.setId(2);
//
//		clienteRepository.save(cliente);
//
//		Optional<Cliente> cl = clienteRepository.findById(id);
//
//		assertThat(cl.get().getId() == id);
//	}
//
//	/**
//	 * Metodo donde se prueba si se listan todos los Clientes
//	 */
//	@Test
//	public void TestListCliente() {
//
//		List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
//
//		for (Cliente cliente : clientes) {
//
//			System.out.println(cliente);
//		}
//
//		assertThat(clientes).size().isGreaterThan(0);
//
//	}
//
//	/**
//	 * Metodo donde se prueba si se elimina un cliente en la
//	 * base de datos
//	 */
//	@Test
//	public void testDeleteCliente() {
//
//		int id = 1;
//
//		boolean present1 = clienteRepository.findById(id).isPresent();
//
//		clienteRepository.deleteById(id);
//
//		boolean present2 = clienteRepository.findById(id).isPresent();
//
//		assertTrue(present2);
//		assertFalse(present1);
//	}

}
