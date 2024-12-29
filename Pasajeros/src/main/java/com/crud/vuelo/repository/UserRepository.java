package com.crud.vuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.vuelo.models.Usuario;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<Usuario, Integer>{
	
    Optional<Usuario> findByUsername(String username); 

}
