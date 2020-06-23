package com.cibertec.pe.dawii.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cibertec.pe.dawii.models.entity.Comprobante;
import com.cibertec.pe.dawii.service.IComprobanteService;

@Controller
@RequestMapping("/comprobante")
public class ComprobanteController {

	@Autowired
	private IComprobanteService comprobanteservice;
	
	@GetMapping
	private String show() {
		return "comprobante/comprobante"; 
	}
	
	@GetMapping(value = "/listar/page/{page}", produces = { "application/json" })
	public @ResponseBody Page<Comprobante> toListComprobante(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 6);
		return comprobanteservice.findAll(pageable);
	}
	
	@GetMapping(value = "/listar/{id}", produces = {"application/json" })
	public @ResponseBody Comprobante findComprobante(@PathVariable Integer id){
		return comprobanteservice.findById(id);
	}
	
	@PostMapping(value ="/save", produces = {"application/json"}, consumes = {"application/json"})
	public @ResponseBody Comprobante saveComprobante(@PathVariable Comprobante comprobante ) {
		if(comprobante.getIdcomprobante()== 0 ){
			return comprobanteservice.save(comprobante);
		}else {
			Comprobante updatecomprobante= comprobanteservice.findById(comprobante.getIdcomprobante());
			updatecomprobante.setFechaRegistro(comprobante.getFechaRegistro());
			updatecomprobante.setFechaPago(comprobante.getFechaPago());
			updatecomprobante.setEstado(comprobante.getEstado());
			updatecomprobante.setPedido(comprobante.getPedido());
			updatecomprobante.setCliente(comprobante.getCliente());
			updatecomprobante.setUsuario(comprobante.getUsuario());
			return comprobanteservice.save(updatecomprobante);
		}
	}
	
	@PostMapping(value ="/delete/{id}")
	public @ResponseBody void deleteComprobante(@PathVariable int id) {
		comprobanteservice.delete(id);
	}
}
