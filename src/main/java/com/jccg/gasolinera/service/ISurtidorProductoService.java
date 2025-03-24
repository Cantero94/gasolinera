package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Surtidor;
import com.jccg.gasolinera.model.SurtidorProducto;

import java.util.List;

public interface ISurtidorProductoService {
    // Lectura de todos los registros
    List<SurtidorProducto> getSurtidorProductos();

    // Lectura por ID
    SurtidorProducto findSurtidorProducto(Long idSurtidorProducto);

    // Alta
    void saveSurtidorProducto(SurtidorProducto surtidorProducto);

    // Modificación
    void editSurtidorProducto(Long idOriginal, Surtidor nuevoSurtidor, Producto nuevoProducto);

    // Baja
    void deleteSurtidorProducto(Long idSurtidorProducto);

}