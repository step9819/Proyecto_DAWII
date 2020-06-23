package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "producto_has_caracteristica")
public class ProductoCaracteristicas implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductoCaracteristicasPK clave;

	private String valor;

	public ProductoCaracteristicasPK getClave() {
		return clave;
	}

	public void setClave(ProductoCaracteristicasPK clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
