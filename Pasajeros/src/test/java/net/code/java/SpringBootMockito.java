package net.code.java;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.crud.vuelo.entity.Cliente;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.service.ClienteService;

/**
 * Esta clase representa las Pruebas unitarias de la aplicación
 * 
 * @author: Danny Macias Vanegas
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SpringBootMockito {

	/**
	 * Objetos con los metodos de obtener, listar, eliminar y editar
	 */
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Metodo donde se crea un nuevo CLiente, luego se verifica si fue creado en la
	 * Base de Datos
	 */
	@Test
	@Rollback(false)
	public void getClienteTest() {

		Cliente cliente = new Cliente(523, "David", "5214", "david@");

		Cliente savedCliente = clienteRepository.save(cliente);

		assertNotNull(savedCliente);

	}

	/**
	 * Metodo donde se actualiza un CLiente,
	 *  luego se verifica si fue editado en la Base de Datos
	 */
	@Test
	@Rollback(false)
	public void testUpdateCliente() {

		int id = 4533;
		Cliente cliente = new Cliente(id, "Andrea", "85633", "Andrea@");
		cliente.setId(2);

		clienteRepository.save(cliente);

		Optional<Cliente> cl = clienteRepository.findById(id);

		assertThat(cl.get().getId() == id);
	}

	/**
	 * Metodo donde se prueba si se listan todos los Clientes
	 */
	@Test
	public void TestListCliente() {

		List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();

		for (Cliente cliente : clientes) {

			System.out.println(cliente);
		}

		assertThat(clientes).size().isGreaterThan(0);

	}

	/**
	 * Metodo donde se prueba si se elimina un cliente en la
	 * base de datos
	 */
	@Test
	public void testDeleteCliente() {

		int id = 1;

		boolean present1 = clienteRepository.findById(id).isPresent();

		clienteRepository.deleteById(id);

		boolean present2 = clienteRepository.findById(id).isPresent();

		assertTrue(present2);
		assertFalse(present1);
	}

}
