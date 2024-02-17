package com.crud.vuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.vuelo.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
	
	

}
