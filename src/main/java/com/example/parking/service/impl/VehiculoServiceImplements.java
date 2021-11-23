package com.example.parking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.entity.Vehiculo;
import com.example.parking.model.repository.UsuarioRepository;
import com.example.parking.model.repository.VehiculoRepository;
import com.example.parking.service.iface.VehiculoService;

@Service
public class VehiculoServiceImplements implements VehiculoService{

	@Autowired
	private VehiculoRepository vehiculoRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public void createVehiculo(Vehiculo vehiculo) {
		boolean existVehiculo = usuarioRepo.existsById(vehiculo.getIdV());
		if(!existVehiculo) {
			vehiculoRepo.save(vehiculo);
		}		
	}

	@Override
	public void editVehiculo(Vehiculo vehiculo, int idVehiculo) {
		Optional<Vehiculo> existVehiculo = vehiculoRepo.findById(idVehiculo);
		if(existVehiculo.isPresent()) {
			existVehiculo.get().setColor(vehiculo.getColor());
			existVehiculo.get().setMarca(vehiculo.getPlaca());
			existVehiculo.get().setModelo(vehiculo.getModelo());
			existVehiculo.get().setPlaca(vehiculo.getPlaca());
			existVehiculo.get().setTipo(vehiculo.getTipo());
			boolean existGender = usuarioRepo.existsById(vehiculo.getIdU().getIdU());
			if(existGender) {
				existVehiculo.get().setIdU(vehiculo.getIdU());
			}
			vehiculoRepo.save(existVehiculo.get());
		}
	}

	@Override
	public List<Vehiculo> getAll() {
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos = (List<Vehiculo>) vehiculoRepo.findAll();
		return vehiculos;
	}
}
