package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_has_rol")
public class UsuarioRol implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioRolPK clave;

	public UsuarioRolPK getClave() {
		return clave;
	}

	public void setClave(UsuarioRolPK clave) {
		this.clave = clave;
	}

}
