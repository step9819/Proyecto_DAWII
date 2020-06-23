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

import com.cibertec.pe.dawii.models.entity.Cliente;
import com.cibertec.pe.dawii.models.entity.Ubigeo;
import com.cibertec.pe.dawii.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
 
	@Autowired
	private IClienteService clienteservice;
	
	@GetMapping("")
	private String show() {
		return "cliente/cliente";
	}
	
	@GetMapping(value = "/listar/page/{page}", produces = {"application/json"})
	public @ResponseBody Page<Cliente> toListCliente(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 7);
		return clienteservice.findAll(pageable);
	}
	
	@GetMapping(value = "/listar/{id}", produces = { "application/json"})
	public @ResponseBody Cliente findCliente(@PathVariable Integer id) {
		return clienteservice.findById(id);
	}
	
	@PostMapping(value = "/save", produces = {"application/json"},consumes = { "application/json" })
	public @ResponseBody Cliente saveCliente(@RequestBody Cliente cliente) {
		if(cliente.getId()==0) {
			return clienteservice.save(cliente);
		}else {
			Cliente updatecliente= clienteservice.findById(cliente.getId());
			updatecliente.setCorreo(cliente.getCorreo());
			updatecliente.setFechaRegistro(cliente.getFechaRegistro());
			updatecliente.setLogin(cliente.getLogin());
			updatecliente.setPassword(cliente.getPassword());
			updatecliente.setDireccion(cliente.getDireccion());
			updatecliente.setEstado(cliente.getEstado());
			return clienteservice.save(updatecliente);
		}
	}
	
	@PostMapping(value = "/delete/{id}")
	public @ResponseBody void deleteCliente(@PathVariable int id) {
		clienteservice.delete(id);
	}
	
	@GetMapping(value = "/ubigeo", produces = { "application/json" })
	public @ResponseBody List<Ubigeo> findUbigeo() {
		return clienteservice.findUbigeo();
	}
}
