package com.crud.vuelo.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.crud.vuelo.before.models.Empresa;
import com.crud.vuelo.before.repository.EmpresaRepository;

@DataJpaTest
public class EmpresaRepositoryTests {
	
	
	@Autowired
	private EmpresaRepository  empresaRepository;
	
	private Empresa empresa;
	
	 @BeforeEach
	 void setup(){
		 empresa = Empresa.builder()
				 	.idEmpresa(147852)
	                .nombre("VuelosAir")
	                .telefono(7344785)
	                .paginaWeb("c1@gmail.com")
	                .build();
	 }
	 
	 @Test
		void testFindById() {
			
			Optional<Empresa> empresa= empresaRepository.findById(152811);
			
			assertTrue(empresa.isPresent());
			assertEquals("Vuelos",empresa.orElseThrow().getNombre());
		}
	 
	 @DisplayName("Test para guardar un cliente")
	 @Test
	 void testGuardarEmpresa(){

		 Empresa empresaObj = Empresa.builder()
				 	.idEmpresa(1522447)
	                .nombre("Pepe")
	                .telefono(7344785)
	                .paginaWeb("c1@gmail.com")
	                .build();

		 Empresa empresaGuardado = empresaRepository.save(empresaObj);

	        assertThat(empresaGuardado).isNotNull();
	        assertThat(empresaGuardado.getIdEmpresa()).isGreaterThan(0);
	    }
	 
	 
	 
	 
	 

}
