package com.crud.vuelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.vuelo.models.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>{
	
    Optional<Usuario> findByUsername(String username); 

}
