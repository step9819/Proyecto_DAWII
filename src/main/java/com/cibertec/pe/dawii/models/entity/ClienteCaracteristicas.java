package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_has_caracteristicacliente")
public class ClienteCaracteristicas implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClienteCaracteristicasPK clave;

	public ClienteCaracteristicasPK getClave() {
		return clave;
	}

	public void setClave(ClienteCaracteristicasPK clave) {
		this.clave = clave;
	}

}
