package com.jccg.gasolinera.repository;

import com.jccg.gasolinera.model.Precio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrecioRepository extends JpaRepository<Precio, Long> {

}