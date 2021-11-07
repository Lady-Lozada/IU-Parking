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

import com.example.parking.model.entity.Pagos;
import com.example.parking.service.iface.PagosService;

@RestController
@RequestMapping("/pagos")
@CrossOrigin("*")
public class PagosController {

	@Autowired
	private PagosService pagoService;
	
	@GetMapping("/all")
	public List<Pagos> getAll(){
		return pagoService.getAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createPago(@RequestBody Pagos pago) {
		pagoService.createPago(pago);
	}
	
	/*@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editPago(@RequestBody Pagos pago, @PathVariable int id) {
		pagoService.editPago(pago, id);
	}*/

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deletePago( @PathVariable int id) {
		pagoService.deletePagos(id);
	}
}
