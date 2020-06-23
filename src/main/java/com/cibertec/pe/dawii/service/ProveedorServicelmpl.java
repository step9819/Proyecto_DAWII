package com.cibertec.pe.dawii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.pe.dawii.models.dao.IProveedorDao;
import com.cibertec.pe.dawii.models.entity.Proveedor;
import com.cibertec.pe.dawii.models.entity.Ubigeo;

@Service
public class ProveedorServicelmpl implements IProveedorService{

	@Autowired
	private IProveedorDao proveedordao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Proveedor> findAll(Pageable pageable){
		return proveedordao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Proveedor findById(int id) {
		return proveedordao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		return proveedordao.save(proveedor);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		proveedordao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Ubigeo> findUbigeo(){
		return proveedordao.findUbigeo();
	}
}
