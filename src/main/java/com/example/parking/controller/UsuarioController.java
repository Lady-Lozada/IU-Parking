package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.model.entity.Usuario;
import com.example.parking.service.iface.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/all")
	public List<Usuario> getAll(){
		return usuarioService.getAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createUser(@RequestBody Usuario usr) {
		usuarioService.createUsuario(usr);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editUser(@RequestBody Usuario usr, @PathVariable int id) {
		usuarioService.editRegistro(usr, id);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteUser( @PathVariable int id) {
		usuarioService.deleteRegistro(id);
	}
}
