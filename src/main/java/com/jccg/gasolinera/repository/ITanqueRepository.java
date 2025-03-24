package com.jccg.gasolinera.repository;

import com.jccg.gasolinera.model.Tanque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITanqueRepository extends JpaRepository<Tanque, Long> {

}