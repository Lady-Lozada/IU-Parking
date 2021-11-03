package com.example.parking.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.model.entity.Usuario;

@RestController
@RequestMapping("/celda")
@CrossOrigin("*")
public class CeldaController {

	Usuario user = new Usuario();

	
}
