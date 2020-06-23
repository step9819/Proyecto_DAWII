package com.cibertec.pe.dawii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.pe.dawii.models.dao.IPedidoDao;
import com.cibertec.pe.dawii.models.entity.Pedido;

@Service
public class PedidoServicelmpl implements IPedidoService{

	@Autowired
	private IPedidoDao pedidodao;

	@Override
	@Transactional(readOnly = true)
	public Page<Pedido> findAll(Pageable pageable){
		return pedidodao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Pedido findById(int id) {
		return pedidodao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Pedido save(Pedido pedido) {
		return pedidodao.save(pedido);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		 pedidodao.deleteById(id);
	}
}
