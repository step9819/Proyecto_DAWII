package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PedidoProductoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Pedido idpedido;

	@ManyToOne
	private Producto idproducto;

	public Pedido getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Pedido idpedido) {
		this.idpedido = idpedido;
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
		result = prime * result + ((idpedido == null) ? 0 : idpedido.hashCode());
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
		PedidoProductoPK other = (PedidoProductoPK) obj;
		if (idpedido == null) {
			if (other.idpedido != null)
				return false;
		} else if (!idpedido.equals(other.idpedido))
			return false;
		if (idproducto == null) {
			if (other.idproducto != null)
				return false;
		} else if (!idproducto.equals(other.idproducto))
			return false;
		return true;
	}

}
