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

import com.cibertec.pe.dawii.models.entity.Marca;
import com.cibertec.pe.dawii.models.entity.Pais;
import com.cibertec.pe.dawii.models.entity.Producto;
import com.cibertec.pe.dawii.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private IProductoService productoservice;

	@GetMapping("")
	private String show() {
		return "producto/producto";
	}

	@GetMapping(value = "/listar/page/{page}", produces = { "application/json" })
	public @ResponseBody Page<Producto> toListProducto(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 6);
		return productoservice.findAll(pageable);
	}

	@GetMapping(value = "/listar/{id}", produces = { "application/json" })
	public @ResponseBody Producto findProducto(@PathVariable Integer id) {
		return productoservice.findById(id);
	}

	@PostMapping(value = "/save", produces = { "application/json" }, consumes = { "application/json" })
	public @ResponseBody Producto saveProducto(@RequestBody Producto producto) {
		// System.out.println(producto.getId());
		if (producto.getIdproducto() == 0) {
			return productoservice.save(producto);
		} else {
			Producto updateproducto = productoservice.findById(producto.getIdproducto());
			updateproducto.setMarca(producto.getMarca());
			updateproducto.setSerie(producto.getSerie());
			updateproducto.setPais(producto.getPais());
			updateproducto.setMarca(producto.getMarca());
			return productoservice.save(updateproducto);
		}
	}

	@PostMapping(value = "/delete/{id}")
	public @ResponseBody void deleteProducto(@PathVariable int id) {
		productoservice.delete(id);
	}

	// METODOS DEL COMBO
	@GetMapping(value = "/pais", produces = { "application/json" })
	public @ResponseBody List<Pais> findPais() {
		return productoservice.findPais();
	}
	
	@GetMapping(value = "/marca", produces = { "application/json" })
	public @ResponseBody List<Marca> findMarca() {
		return productoservice.findMarca();
	}

}
