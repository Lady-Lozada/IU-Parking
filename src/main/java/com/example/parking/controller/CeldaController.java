package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.model.entity.Celda;
import com.example.parking.service.iface.CeldaService;

@RestController
@RequestMapping("/celda")
@CrossOrigin("*")
public class CeldaController {

	@Autowired
	private CeldaService celdaService;
	
	@GetMapping("/all")
	public List<Celda> getAll(){
		return celdaService.getAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createCelda(@RequestBody Celda celda) {
		celdaService.createCelda(celda);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editCelda(@RequestBody Celda celda, @PathVariable int id) {
		celdaService.editCelda(celda, id);
	}
	
}
