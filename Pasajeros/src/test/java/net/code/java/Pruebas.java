package net.code.java;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.crud.vuelo.entity.Cliente;

@Component
public interface Pruebas extends JpaRepository<Cliente,Integer> {
}
