package com.cibertec.pe.dawii.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cibertec.pe.dawii.models.entity.Usuario;

public interface IUsuarioService {

	public Page<Usuario> findAll (Pageable pageable);
	
	public Usuario findById(int id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(int id);
}
