package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caracteristicacliente")
public class CaracteristicaCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcaracteristicaCliente;

	private String nombre;

	private String estado;

	public int getIdcaracteristicaCliente() {
		return idcaracteristicaCliente;
	}

	public void setIdcaracteristicaCliente(int idcaracteristicaCliente) {
		this.idcaracteristicaCliente = idcaracteristicaCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
