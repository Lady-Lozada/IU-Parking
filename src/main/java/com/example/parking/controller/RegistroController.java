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

import com.example.parking.model.entity.Registro;
import com.example.parking.service.iface.RegistroService;

@RestController
@RequestMapping("/registro")
@CrossOrigin("*")
public class RegistroController {

	@Autowired
	private RegistroService registroService;
	
	@GetMapping("/all")
	public List<Registro> getAll(){
		return registroService.getAll();
	}
	
	@PostMapping("/create") // INGRESO DE VEHICULO
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createRegistro(@RequestBody Registro reg) {
		registroService.createRegistro(reg);
	}
	
	@PutMapping("/update/{id}") // ACTUALIZACION
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editRegistro(@RequestBody Registro reg, @PathVariable int id) {
		registroService.editRegistro(reg, id);
	}
	
	@PutMapping("/updateSalida/{id}") // SALIDA DE VEHICULO
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editSalidaRegistro(@PathVariable int id) {
		registroService.editSalidaRegistro(id);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteRegistro( @PathVariable int id) {
		registroService.deleteRegistro(id);
	}
}
