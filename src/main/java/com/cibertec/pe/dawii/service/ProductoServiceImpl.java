package com.cibertec.pe.dawii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.pe.dawii.models.dao.IProductoDao;
import com.cibertec.pe.dawii.models.entity.Marca;
import com.cibertec.pe.dawii.models.entity.Pais;
import com.cibertec.pe.dawii.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDao productodao; 
	
	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {		
		return productodao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(int id) {		
		return productodao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {		
		return productodao.save(producto);
	}

	@Override
	@Transactional
	public void delete(int id) {		
		productodao.deleteById(id);
	}

	
	// METODOS DE COMBOS
	@Override
	@Transactional(readOnly = true)
	public List<Pais> findPais() {		
		return productodao.findPais();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findMarca() {		
		return productodao.findMarca();
	}

}
