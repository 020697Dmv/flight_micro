package com.crud.vuelo.before.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.vuelo.before.models.Tiquetes;

@Repository
public interface TiquetesRepository  extends JpaRepository<Tiquetes, Integer>{

}
