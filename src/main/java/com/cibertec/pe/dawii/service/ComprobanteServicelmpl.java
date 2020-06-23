package com.cibertec.pe.dawii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.pe.dawii.models.dao.IComprobanteDao;
import com.cibertec.pe.dawii.models.entity.Comprobante;

@Service
public class ComprobanteServicelmpl implements IComprobanteService{
	
	@Autowired
	private IComprobanteDao comprobantedao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Comprobante> findAll(Pageable pageable){
		return comprobantedao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Comprobante findById(int id) {
		return comprobantedao.findById(id).orElse(null);
	}
	// :D
	@Override
	@Transactional
	public Comprobante save(Comprobante comprobante) {
		return comprobantedao.save(comprobante);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		comprobantedao.deleteById(id);
	}
}
