package com.crud.vuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.vuelo.models.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer>{

}
