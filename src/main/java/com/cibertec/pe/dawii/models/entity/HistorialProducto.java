package com.cibertec.pe.dawii.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historialproducto")
public class HistorialProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorialProducto;

	private Date fechaRegistro;

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	private Producto producto;

	public int getIdHistorialProducto() {
		return idHistorialProducto;
	}

	public void setIdHistorialProducto(int idHistorialProducto) {
		this.idHistorialProducto = idHistorialProducto;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
