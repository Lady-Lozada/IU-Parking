package com.example.parking.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.entity.Registro;

@Repository
public interface RegistroRepository extends CrudRepository<Registro, Integer> {

}
