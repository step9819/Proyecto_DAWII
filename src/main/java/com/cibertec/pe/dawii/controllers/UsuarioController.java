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

import com.cibertec.pe.dawii.models.entity.Usuario;
import com.cibertec.pe.dawii.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioservice;
	
	@GetMapping("")
	private String show() {
		return "usuario/usuario";
	}
	
	@GetMapping(value = "/listar/page/{page}", produces = {"application/json"})
	public @ResponseBody Page<Usuario> toListUsuario(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 6);
		return usuarioservice.findAll(pageable);
	}
	
	@GetMapping(value = "/listar/{id}", produces = {"application/json"})
	public @ResponseBody Usuario findUsuario(@PathVariable Integer id) {
		return usuarioservice.findById(id);
	}
	
	@PostMapping(value = "/save", produces = {"application/json"}, consumes = {"application/json"})
	public @ResponseBody Usuario saveUsuario(@RequestBody Usuario usuario) {
		if(usuario.getIdusuario() == 0) {
			return usuarioservice.save(usuario);
		}else {
			Usuario updateusuario = usuarioservice.findById(usuario.getIdusuario());
			updateusuario.setNombre(usuario.getNombre());
			updateusuario.setApellido(usuario.getApellido());
			updateusuario.setDni(usuario.getDni());
			updateusuario.setLogin(usuario.getLogin());
			updateusuario.setPassword(usuario.getPassword());
			return usuarioservice.save(updateusuario);
		}
	}
	
	@PostMapping(value = "/delete/{id}")
	public @ResponseBody void deleteUsuario(@PathVariable int id) {
		usuarioservice.delete(id);
	}
}
