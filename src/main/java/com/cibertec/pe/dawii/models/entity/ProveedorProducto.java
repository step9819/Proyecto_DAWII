package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor_has_producto")
public class ProveedorProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProveedorProductoPK clave;

	private int stock;

	private double precio;

	private int tiempoEntrega;

	private double costoAdicional;

	private double precioFinal;

	public ProveedorProductoPK getClave() {
		return clave;
	}

	public void setClave(ProveedorProductoPK clave) {
		this.clave = clave;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(int tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public double getCostoAdicional() {
		return costoAdicional;
	}

	public void setCostoAdicional(double costoAdicional) {
		this.costoAdicional = costoAdicional;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

}
