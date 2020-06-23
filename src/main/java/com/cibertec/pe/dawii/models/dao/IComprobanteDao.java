package com.cibertec.pe.dawii.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.pe.dawii.models.entity.Comprobante;

public interface IComprobanteDao extends CrudRepository<Comprobante, Integer>{

	public Page<Comprobante> findAll(Pageable pageable);
	
	
}
