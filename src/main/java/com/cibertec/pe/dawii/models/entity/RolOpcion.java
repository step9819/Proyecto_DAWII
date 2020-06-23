package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rol_has_opcion")
public class RolOpcion implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolOpcionPK clave;

	public RolOpcionPK getClave() {
		return clave;
	}

	public void setClave(RolOpcionPK clave) {
		this.clave = clave;
	}

}
