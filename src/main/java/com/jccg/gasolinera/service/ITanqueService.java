package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Tanque;

import java.util.List;

public interface ITanqueService {
    // Lectura de todos los registros
    List<Tanque> getTanques();

    // Lectura por ID
    Tanque findTanque(Long idTanque);

    // Alta
    void saveTanque(Tanque tanque);

    // Modificación
    void editTanque(Long idOriginal, Producto nuevoProducto, String nuevoCodigo, Integer nuevaCapacidadMaxima, Integer nuevoNivelActual);

    // Baja
    void deleteTanque(Long idTanque);
}