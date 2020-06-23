package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ClienteCaracteristicasPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Cliente idcliente;

	@ManyToOne
	private CaracteristicaCliente idcaracteristicacliente;

	public Cliente getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Cliente idcliente) {
		this.idcliente = idcliente;
	}

	public CaracteristicaCliente getIdcaracteristicacliente() {
		return idcaracteristicacliente;
	}

	public void setIdcaracteristicacliente(CaracteristicaCliente idcaracteristicacliente) {
		this.idcaracteristicacliente = idcaracteristicacliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcaracteristicacliente == null) ? 0 : idcaracteristicacliente.hashCode());
		result = prime * result + ((idcliente == null) ? 0 : idcliente.hashCode());
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
		ClienteCaracteristicasPK other = (ClienteCaracteristicasPK) obj;
		if (idcaracteristicacliente == null) {
			if (other.idcaracteristicacliente != null)
				return false;
		} else if (!idcaracteristicacliente.equals(other.idcaracteristicacliente))
			return false;
		if (idcliente == null) {
			if (other.idcliente != null)
				return false;
		} else if (!idcliente.equals(other.idcliente))
			return false;
		return true;
	}

}
