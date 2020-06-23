package com.cibertec.pe.dawii.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cibertec.pe.dawii.models.entity.Marca;
import com.cibertec.pe.dawii.models.entity.Pais;
import com.cibertec.pe.dawii.models.entity.Producto;

public interface IProductoService {

	// METODOS DEL CRUD
	public Page<Producto> findAll(Pageable pageable);
	
	public Producto findById(int id);

	public Producto save(Producto producto);	

	public void delete(int id);

	
	// METODOS DEL COMBO
	public List<Pais> findPais();
	
	public List<Marca> findMarca();
	
}
