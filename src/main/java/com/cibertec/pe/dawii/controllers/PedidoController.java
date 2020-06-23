package com.cibertec.pe.dawii.controllers;

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

import com.cibertec.pe.dawii.models.entity.Pedido;
import com.cibertec.pe.dawii.service.IPedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private IPedidoService pedidoservice;
	
	@GetMapping("")
	private String show() {
		return "pedido/pedido";
	}
	
	@GetMapping(value = "/listar/page/{page}", produces = { "application/json" })
	public @ResponseBody Page<Pedido> toListPedido(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 6);
		return pedidoservice.findAll(pageable);
	}
	
	@GetMapping(value = "/listar/{id}", produces = {"application/json"})
	public @ResponseBody Pedido findPedido(@PathVariable Integer id) {
		return pedidoservice.findById(id);
	}
	
	@PostMapping(value = "/save", produces = {"application/json"}, consumes = {"application/json"})
	public @ResponseBody Pedido savePedido(@RequestBody Pedido pedido) {
		if(pedido.getIdPedido()== 0) {
			return pedidoservice.save(pedido);
		}else {
			Pedido updatepedido = pedidoservice.findById(pedido.getIdPedido());
			updatepedido.setFechaRegistro(pedido.getFechaRegistro());
			updatepedido.setFechaEntrega(pedido.getFechaEntrega());
			updatepedido.setLugarEntrega(pedido.getLugarEntrega());
			updatepedido.setEstado(pedido.getEstado());
			updatepedido.setCliente(pedido.getCliente());
			updatepedido.setUbigeo(pedido.getUbigeo());
			return pedidoservice.save(updatepedido);
		}		
	}
	
	@PostMapping(value = "/delete")
	public @ResponseBody void deletePedido(@PathVariable int id) {
		pedidoservice.delete(id);
	}
	
}
