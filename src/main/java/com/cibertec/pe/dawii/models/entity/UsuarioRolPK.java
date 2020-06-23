package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UsuarioRolPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Usuario idusuario;

	@ManyToOne
	private Rol idrol;

	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

	public Rol getIdrol() {
		return idrol;
	}

	public void setIdrol(Rol idrol) {
		this.idrol = idrol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
		result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
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
		UsuarioRolPK other = (UsuarioRolPK) obj;
		if (idrol == null) {
			if (other.idrol != null)
				return false;
		} else if (!idrol.equals(other.idrol))
			return false;
		if (idusuario == null) {
			if (other.idusuario != null)
				return false;
		} else if (!idusuario.equals(other.idusuario))
			return false;
		return true;
	}

}
