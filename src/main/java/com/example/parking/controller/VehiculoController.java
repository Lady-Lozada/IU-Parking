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

import com.example.parking.model.entity.Vehiculo;
import com.example.parking.service.iface.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin("*")
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@GetMapping("/all")
	public List<Vehiculo> getAll(){
		return vehiculoService.getAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createVehiculo(@RequestBody Vehiculo vehiculo) {
		vehiculoService.createVehiculo(vehiculo);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable int id) {
		vehiculoService.editVehiculo(vehiculo, id);
	}

	/*@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteVehiculo( @PathVariable int id) {
		vehiculoService.deleteMovie(id);
	}*/
	
}
