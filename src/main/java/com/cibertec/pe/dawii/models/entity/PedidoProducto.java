package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_has_producto")
public class PedidoProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoProductoPK clave;

	public PedidoProductoPK getClave() {
		return clave;
	}

	public void setClave(PedidoProductoPK clave) {
		this.clave = clave;
	}

}
