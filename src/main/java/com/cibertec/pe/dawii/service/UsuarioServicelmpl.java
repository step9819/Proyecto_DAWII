package com.cibertec.pe.dawii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.pe.dawii.models.dao.IUsuarioDao;
import com.cibertec.pe.dawii.models.entity.Usuario;


@Service
public class UsuarioServicelmpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuariodao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable){
		return usuariodao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		return usuariodao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuariodao.save(usuario);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		usuariodao.deleteById(id);
	}
}
