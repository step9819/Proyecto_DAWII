package com.cibertec.pe.dawii.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.pe.dawii.models.entity.Proveedor;
import com.cibertec.pe.dawii.models.entity.Ubigeo;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer>{

	public Page<Proveedor> findAll(Pageable pageable);
	
	
	
	@Query("select u from Ubigeo u")
	public List<Ubigeo> findUbigeo();
	
}
