package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Surtidor;

import java.time.LocalDate;
import java.util.List;

public interface ISurtidorService {

    // Lectura de todos los registros
    List<Surtidor> getSurtidores();

    // Lectura por ID
    Surtidor findSurtidor(Long idSurtidor);
    // Alta
    void saveSurtidor(Surtidor surtidor);

    // Modificación
    void editSurtidor(Long idOriginal, String nuevoCodigo, LocalDate nuevaFechaInstalacion, boolean nuevoActivo);

    // Baja
    void deleteSurtidor(Long idSurtidor);
}