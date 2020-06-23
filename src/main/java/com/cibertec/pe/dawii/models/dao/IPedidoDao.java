package com.cibertec.pe.dawii.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.pe.dawii.models.entity.Pedido;

public interface IPedidoDao extends CrudRepository<Pedido, Integer>{

	public Page<Pedido> findAll(Pageable pageable);
}
