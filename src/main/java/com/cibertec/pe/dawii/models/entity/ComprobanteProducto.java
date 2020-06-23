package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comprobante_has_producto")
public class ComprobanteProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComprobanteProductoPK clave;

	private double precio;

	private int stock;

	public ComprobanteProductoPK getClave() {
		return clave;
	}

	public void setClave(ComprobanteProductoPK clave) {
		this.clave = clave;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
