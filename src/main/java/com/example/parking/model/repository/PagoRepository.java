package com.example.parking.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.entity.Pagos;

@Repository
public interface PagoRepository extends CrudRepository<Pagos, Integer> {

}
