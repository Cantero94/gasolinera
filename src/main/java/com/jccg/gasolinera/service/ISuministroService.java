package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Suministro;
import com.jccg.gasolinera.model.Surtidor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ISuministroService {

    // Lectura de todos los registros
    List<Suministro> getSuministros();

    // Lectura por ID
    Suministro findSuministro(Long idSuministro);

    // Alta
    void saveSuministro(Suministro suministro);

    // Modificación
    void editSuministro(Long idOriginal,
                               Surtidor nuevoSurtidor,
                               Producto nuevoProducto,
                               LocalDateTime nuevaFechaHora,
                               BigDecimal nuevoVolumenLitros,
                               BigDecimal nuevoImporteEuros);

    // Baja
    void deleteSuministro(Long idSuministro);
}