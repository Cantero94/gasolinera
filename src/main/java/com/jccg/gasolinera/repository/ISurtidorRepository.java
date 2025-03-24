package com.jccg.gasolinera.repository;

import com.jccg.gasolinera.model.Surtidor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurtidorRepository extends JpaRepository<Surtidor, Long> {

}
