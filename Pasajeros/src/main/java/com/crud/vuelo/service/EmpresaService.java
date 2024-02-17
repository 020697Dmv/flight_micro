package com.crud.vuelo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.vuelo.models.Empresa;

public interface EmpresaService {
	
	public List<Empresa> findAllEmpresas();

	public ResponseEntity<Empresa> findEmpresa(int id);

	public Empresa saveEmpresa(Empresa empresaNueva);

	public ResponseEntity<Object> deleteEmpresa(int id);

	public ResponseEntity<?> updateEmpresa(Empresa newEmpresa, int id);

}
