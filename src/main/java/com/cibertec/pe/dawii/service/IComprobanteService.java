package com.cibertec.pe.dawii.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.cibertec.pe.dawii.models.entity.Comprobante;

public interface IComprobanteService{
	
	public Page<Comprobante> findAll(Pageable pageable);
	
	public Comprobante findById (int id);
	
	public Comprobante save(Comprobante comprobante);
	
	public void delete(int id);
}
