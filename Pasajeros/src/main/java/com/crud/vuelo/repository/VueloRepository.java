package com.crud.vuelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.vuelo.models.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer>{ 




	Optional<Vuelo> findByidVuelo(int idVuelo);
	

	@Query(value="SELECT ob.CAPACIDAD FROM VUELO ob WHERE ob.AEROPUERTOFK = :aeropuertoFK", nativeQuery = true)
	Optional<Integer> findByCapacidad(@Param("aeropuertoFK") String aeropuertoFK);

	
	
	
	
	
}
