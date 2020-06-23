package com.cibertec.pe.dawii.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cibertec.pe.dawii.models.entity.Pedido;

public interface IPedidoService {

	public Page<Pedido> findAll(Pageable pageable);
	
	public Pedido findById(int id);
	
	public Pedido save(Pedido pedido);
	
	public void delete(int id);
}
