package com.cibertec.pe.dawii.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cibertec.pe.dawii.models.entity.Cliente;
import com.cibertec.pe.dawii.models.entity.Ubigeo;

public interface IClienteService {

	public Page<Cliente> findAll(Pageable peagable);
	
	public Cliente findById(int id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(int id);	
	
	public List<Ubigeo> findUbigeo();
}
