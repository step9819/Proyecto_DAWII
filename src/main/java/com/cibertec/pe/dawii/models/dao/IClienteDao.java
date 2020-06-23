package com.cibertec.pe.dawii.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.pe.dawii.models.entity.Cliente;
import com.cibertec.pe.dawii.models.entity.Ubigeo;

public interface IClienteDao extends CrudRepository<Cliente, Integer>{
	
	public Page<Cliente> findAll(Pageable pageable);

	
	//COMBO
	@Query("select u from Ubigeo u")
	public List<Ubigeo> findUbigeo();
}
