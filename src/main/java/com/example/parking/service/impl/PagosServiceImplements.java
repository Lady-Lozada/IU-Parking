package com.example.parking.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.entity.Pagos;
import com.example.parking.model.repository.PagoRepository;
import com.example.parking.model.repository.UsuarioRepository;
import com.example.parking.service.iface.PagosService;

@Service
public class PagosServiceImplements implements PagosService{

	@Autowired
	private PagoRepository pagoRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public List<Pagos> getAll() {
		List<Pagos> pagos = new ArrayList<>();
		pagos = (List<Pagos>) pagoRepo.findAll();
		return pagos;
	}

	@Override
	public void createPago(Pagos pago) {
		boolean existUsuario = usuarioRepo.existsById(pago.getIdU().getIdU());
		if(existUsuario) {
			pago.setfPago(LocalDateTime.now());
			pagoRepo.save(pago);
		}
	}

	@Override
	public void editPago(Pagos pago, int pagoId) {
		Optional<Pagos> existPago = pagoRepo.findById(pagoId);
		if(existPago.isPresent()) {
			existPago.get().setfPago(pago.getfPago());
			boolean existUsuario = usuarioRepo.existsById(pago.getIdU().getIdU());
			if(existUsuario) {
				existPago.get().setIdU(pago.getIdU());
			}
			pagoRepo.save(existPago.get());
		}
	}

	@Override /* Este metodo me queda la duda si es necesario */
	public void deletePagos(int pagoId) {
		Optional<Pagos> existPago = pagoRepo.findById(pagoId);
		if(existPago.isPresent()) {
			pagoRepo.delete(existPago.get());
		}
	}

}
