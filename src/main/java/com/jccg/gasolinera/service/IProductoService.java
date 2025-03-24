package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Producto;

import java.util.List;

public interface IProductoService {
    // Lectura de todos los registros
    List<Producto> getProductos();

    // Lectura por ID
    Producto findProducto(Long idProducto);

    // Alta
    void saveProducto(Producto producto);

    // Modificación
    void editProducto(Long idOriginal, String nuevoNombre, String nuevaDescripcion, String nuevoTipo);

    // Baja
    void deleteProducto(Long idProducto);
}
