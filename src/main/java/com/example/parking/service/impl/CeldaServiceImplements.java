package com.example.parking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.entity.Celda;
import com.example.parking.model.repository.CeldaRepository;
import com.example.parking.model.repository.RegistroRepository;
import com.example.parking.service.iface.CeldaService;

@Service
public class CeldaServiceImplements implements CeldaService{

	@Autowired
	private CeldaRepository celdaRepo;
	
	@Autowired
	private RegistroRepository registroRepo;
	
	@Override
	public List<Celda> getAll() {
		List<Celda> celdas = new ArrayList<>();
		celdas = (List<Celda>) celdaRepo.findAll();
		return celdas;
	}

	@Override
	public void editCelda(Celda celda, int idCelda) {
		Optional<Celda> existCelda = celdaRepo.findById(idCelda);
		if(existCelda.isPresent()) {
			existCelda.get().setSeccion(celda.getSeccion());
			existCelda.get().setTipo(celda.getTipo());
			existCelda.get().setDisponibilidad(celda.getDisponibilidad());
//			boolean existGender = registroRepo.existsById(celda.getIdC());
//			if(existGender) {
				existCelda.get().setIdC(celda.getIdC());
//			}
			celdaRepo.save(existCelda.get());
		}
	}

	@Override
	public void createCelda(Celda celda) {
//		boolean existCelda = registroRepo.existsById(celda.getIdC());
//		if(existCelda) {
			celdaRepo.save(celda);
//		}
	}

}
