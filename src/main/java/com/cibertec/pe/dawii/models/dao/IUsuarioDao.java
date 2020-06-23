package com.cibertec.pe.dawii.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.pe.dawii.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{

	public Page<Usuario> findAll(Pageable pageable);
	
}
