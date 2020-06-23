package com.cibertec.pe.dawii.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cibertec.pe.dawii.models.entity.Proveedor;
import com.cibertec.pe.dawii.models.entity.Ubigeo;

public interface IProveedorService {

	public Page<Proveedor> findAll(Pageable pageable);
	
	public Proveedor findById (int id);
	
	public Proveedor save(Proveedor proveedor);
	
	public void delete (int id);
	
	
	
	public List<Ubigeo> findUbigeo();
}
