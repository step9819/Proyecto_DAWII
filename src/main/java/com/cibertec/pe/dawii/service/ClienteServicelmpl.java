package com.cibertec.pe.dawii.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.pe.dawii.models.dao.IClienteDao;
import com.cibertec.pe.dawii.models.entity.Cliente;
import com.cibertec.pe.dawii.models.entity.Ubigeo;


@Service
public class ClienteServicelmpl implements IClienteService{

	@Autowired
	private IClienteDao clientedao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable){
		return clientedao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(int id) {		
		return clientedao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {		
		return clientedao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(int id) {		
		clientedao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Ubigeo> findUbigeo(){		
		return clientedao.findUbigeo();
	}
}
