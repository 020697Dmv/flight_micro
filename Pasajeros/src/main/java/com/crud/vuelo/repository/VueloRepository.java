package com.crud.vuelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.vuelo.models.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer>{ 




	Optional<Vuelo> findByidVuelo(int idVuelo);
	
	
}
