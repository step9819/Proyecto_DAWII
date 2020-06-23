package com.cibertec.pe.dawii.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.pe.dawii.models.entity.Marca;
import com.cibertec.pe.dawii.models.entity.Pais;
import com.cibertec.pe.dawii.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Integer> {

	public Page<Producto> findAll(Pageable pageable);
	
	
	
	
	// PARA COMBOBOX
	@Query("select p from Pais p")
	public List<Pais> findPais();
	
	@Query("select m from Marca m")
	public List<Marca> findMarca();
	
}
