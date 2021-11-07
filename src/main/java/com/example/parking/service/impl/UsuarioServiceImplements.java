package com.example.parking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.entity.Usuario;
import com.example.parking.model.repository.UsuarioRepository;
import com.example.parking.model.repository.VehiculoRepository;
import com.example.parking.service.iface.UsuarioService;

@Service
public class UsuarioServiceImplements implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private VehiculoRepository vehiculoRepo;
	
	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios = (List<Usuario>) usuarioRepo.findAll();
		return usuarios;
	}

	@Override
	public void createUsuario(Usuario usuario) {
		//boolean existVehiculo = vehiculoRepo.existsById(usuario.getIdV().getIdV());
		//if(existVehiculo) {			
			usuarioRepo.save(usuario);
		//}
	}

	@Override
	public void editRegistro(Usuario usuario, int usuarioId) {
		Optional<Usuario> existUsuario = usuarioRepo.findById(usuarioId);
		if(existUsuario.isPresent()) {
			existUsuario.get().setDocumento(usuario.getDocumento());
			existUsuario.get().setNombre(usuario.getNombre());
			existUsuario.get().setApellido(usuario.getApellido());
			existUsuario.get().setTelefono(usuario.getTelefono());
			existUsuario.get().setEmail(usuario.getEmail());
			//existUsuario.get().setIdV(usuario.getIdV());
			usuarioRepo.save(existUsuario.get());
		}
	}

	@Override
	public void deleteRegistro(int usuarioId) {
		Optional<Usuario> existUsuario = usuarioRepo.findById(usuarioId);
		if(existUsuario.isPresent()) {
			usuarioRepo.delete(existUsuario.get());
		}
	}

}
