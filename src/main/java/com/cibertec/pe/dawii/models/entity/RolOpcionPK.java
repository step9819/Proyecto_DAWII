package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RolOpcionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Rol idrol;

	@ManyToOne
	private Opcion idopcion;

	public Rol getIdrol() {
		return idrol;
	}

	public void setIdrol(Rol idrol) {
		this.idrol = idrol;
	}

	public Opcion getIdopcion() {
		return idopcion;
	}

	public void setIdopcion(Opcion idopcion) {
		this.idopcion = idopcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idopcion == null) ? 0 : idopcion.hashCode());
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolOpcionPK other = (RolOpcionPK) obj;
		if (idopcion == null) {
			if (other.idopcion != null)
				return false;
		} else if (!idopcion.equals(other.idopcion))
			return false;
		if (idrol == null) {
			if (other.idrol != null)
				return false;
		} else if (!idrol.equals(other.idrol))
			return false;
		return true;
	}

}
