package com.example.parking.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.entity.Celda;
import com.example.parking.model.entity.Registro;
import com.example.parking.model.repository.CeldaRepository;
import com.example.parking.model.repository.RegistroRepository;
import com.example.parking.model.repository.VehiculoRepository;
import com.example.parking.service.iface.RegistroService;

@Service
public class RegistroServiceImplements implements RegistroService{

	@Autowired
	private RegistroRepository registroRepo;
	
	@Autowired
	private CeldaRepository celdaRepo;
	
	@Autowired
	private VehiculoRepository vehiculoRepo;
	
	@Override
	public List<Registro> getAll() {
		List<Registro> registros = new ArrayList<>();
		registros = (List<Registro>) registroRepo.findAll();
		return registros;
	}

	@Override
	public void createRegistro(Registro registro) {
		Celda celda = null;
		boolean existVehiculo = vehiculoRepo.existsById(registro.getIdV().getIdV());
		if(existVehiculo) {
			Optional<Celda> existCelda = celdaRepo.findById(registro.getIdC().getIdC());
			if(existCelda.get().getDisponibilidad().toString().equalsIgnoreCase("SI")) {
				registro.setfInicio(LocalDateTime.now());
				registroRepo.save(registro);	
				celda = existCelda.get();
				celda.setDisponibilidad("NO");
				celdaRepo.save(celda);
			}/*else {
				celdaRepo.findAll();
			}*/
			
		}
	}

	@Override
	public void editRegistro(Registro registro, int registroId) {
		Optional<Registro> existRegistro = registroRepo.findById(registroId);
		if(existRegistro.isPresent()) {
			existRegistro.get().setfInicio(registro.getfInicio());
			existRegistro.get().setIdC(registro.getIdC());
			existRegistro.get().setIdV(registro.getIdV());
			registroRepo.save(existRegistro.get());
		}
	}

	@Override
	public void editSalidaRegistro(int registroId) {
		Celda celda = null;
		Optional<Registro> existRegistro = registroRepo.findById(registroId);
		Optional<Celda> existCelda = celdaRepo.findById(existRegistro.get().getIdC().getIdC());
		if(existRegistro.isPresent()) {
			existRegistro.get().setfFin(LocalDateTime.now());
			registroRepo.save(existRegistro.get());
			celda = existCelda.get();
			celda.setDisponibilidad("SI");
			celdaRepo.save(celda);
		}
	}
	@Override
	public void deleteRegistro(int registroId) {
		Optional<Registro> existRegistro = registroRepo.findById(registroId);
		if(existRegistro.isPresent()) {
			registroRepo.delete(existRegistro.get());
		}
	}

}
