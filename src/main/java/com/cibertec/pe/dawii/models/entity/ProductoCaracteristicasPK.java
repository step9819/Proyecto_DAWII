package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductoCaracteristicasPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Producto idproducto;

	@ManyToOne
	private Caracteristica idcaracteristica;

	public Producto getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Producto idproducto) {
		this.idproducto = idproducto;
	}

	public Caracteristica getIdcaracteristica() {
		return idcaracteristica;
	}

	public void setIdcaracteristica(Caracteristica idcaracteristica) {
		this.idcaracteristica = idcaracteristica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcaracteristica == null) ? 0 : idcaracteristica.hashCode());
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
		ProductoCaracteristicasPK other = (ProductoCaracteristicasPK) obj;
		if (idcaracteristica == null) {
			if (other.idcaracteristica != null)
				return false;
		} else if (!idcaracteristica.equals(other.idcaracteristica))
			return false;
		if (idproducto == null) {
			if (other.idproducto != null)
				return false;
		} else if (!idproducto.equals(other.idproducto))
			return false;
		return true;
	}

}
