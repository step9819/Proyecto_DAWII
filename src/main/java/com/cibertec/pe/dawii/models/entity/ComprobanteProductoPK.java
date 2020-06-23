package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ComprobanteProductoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Comprobante idcomprobante;

	@ManyToOne
	private Producto idproducto;

	public Comprobante getIdcomprobante() {
		return idcomprobante;
	}

	public void setIdcomprobante(Comprobante idcomprobante) {
		this.idcomprobante = idcomprobante;
	}

	public Producto getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Producto idproducto) {
		this.idproducto = idproducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcomprobante == null) ? 0 : idcomprobante.hashCode());
		result = prime * result + ((idproducto == null) ? 0 : idproducto.hashCode());
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
		ComprobanteProductoPK other = (ComprobanteProductoPK) obj;
		if (idcomprobante == null) {
			if (other.idcomprobante != null)
				return false;
		} else if (!idcomprobante.equals(other.idcomprobante))
			return false;
		if (idproducto == null) {
			if (other.idproducto != null)
				return false;
		} else if (!idproducto.equals(other.idproducto))
			return false;
		return true;
	}

}
