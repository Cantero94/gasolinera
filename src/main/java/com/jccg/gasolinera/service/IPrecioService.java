package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Precio;
import com.jccg.gasolinera.model.Producto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IPrecioService {
    // Lectura de todos los registros
    List<Precio> getPrecios();

    // Lectura por ID
    Precio findPrecio(Long idPrecio);

    // Alta
    void savePrecio(Precio precio);

    // Modificación
    void editPrecio(Long idOriginal, Producto nuevoProducto, LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, BigDecimal nuevoPrecioPorLitro);

    // Baja
    void deletePrecio(Long idPrecio);
}
