package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ProveedorProductoPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Proveedor idproveedor;
	
	@ManyToOne
	private Producto idproducto;

	public Proveedor getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(Proveedor idproveedor) {
		this.idproveedor = idproveedor;
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
		result = prime * result + ((idproducto == null) ? 0 : idproducto.hashCode());
		result = prime * result + ((idproveedor == null) ? 0 : idproveedor.hashCode());
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
		ProveedorProductoPK other = (ProveedorProductoPK) obj;
		if (idproducto == null) {
			if (other.idproducto != null)
				return false;
		} else if (!idproducto.equals(other.idproducto))
			return false;
		if (idproveedor == null) {
			if (other.idproveedor != null)
				return false;
		} else if (!idproveedor.equals(other.idproveedor))
			return false;
		return true;
	}
	
	
	
		
	

}
