package com.cibertec.pe.dawii.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cibertec.pe.dawii.models.entity.Proveedor;
import com.cibertec.pe.dawii.models.entity.Ubigeo;
import com.cibertec.pe.dawii.service.IProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorservice;

	@GetMapping("")
	private String show() {
		return "proveedor/proveedor";
	}

	@GetMapping(value = "/listar/page/{page}", produces = { "application/json" })
	public @ResponseBody Page<Proveedor> toListProveedor(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 6);
		return proveedorservice.findAll(pageable);
	}

	@GetMapping(value = "/listar/{id}", produces = { "application/json" })
	public @ResponseBody Proveedor findProveedor(@PathVariable Integer id) {
		return proveedorservice.findById(id);
	}

	@PostMapping(value = "/save", produces = { "application/json" },consumes = { "application/json" })
	public @ResponseBody Proveedor saveProveedor(@RequestBody Proveedor proveedor) {
		if (proveedor.getIdproveedor() == 0) {
			return proveedorservice.save(proveedor);
		} else {
			Proveedor updateproveedor = proveedorservice.findById(proveedor.getIdproveedor());
			updateproveedor.setRazonsocial(proveedor.getRazonsocial());
			updateproveedor.setRuc(proveedor.getRuc());
			updateproveedor.setDireccion(proveedor.getDireccion());
			updateproveedor.setTelefono(proveedor.getTelefono());
			updateproveedor.setCelular(proveedor.getCelular());
			updateproveedor.setContacto(proveedor.getContacto());
			updateproveedor.setUbigeo(proveedor.getUbigeo());
			return proveedorservice.save(updateproveedor);
		}
	}

	@PostMapping(value = "/delete/{id}")
	public @ResponseBody void deleteProveedor(@PathVariable int id) {
		proveedorservice.delete(id);
	}

	@GetMapping(value = "/ubigeo", produces = { "application/json" })
	public @ResponseBody List<Ubigeo> findUbigeo() {
		return proveedorservice.findUbigeo();
	}
}
