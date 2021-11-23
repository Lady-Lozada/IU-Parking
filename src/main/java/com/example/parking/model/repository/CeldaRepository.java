package com.example.parking.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.entity.Celda;

@Repository
public interface CeldaRepository extends CrudRepository<Celda, Integer> {
	
	

}
