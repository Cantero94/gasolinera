package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository repoProducto;

    // Lectura de todos los registros
    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = repoProducto.findAll();
        return listaProductos;
    }

    // Lectura por ID
    @Override
    public Producto findProducto(Long idProducto) {
        return repoProducto.findById(idProducto).orElse(null);
    }

    // Alta
    @Override
    public void saveProducto(Producto producto) {
        repoProducto.save(producto);
    }

    // Modificación
    @Override
    public void editProducto(Long idOriginal, String nuevoNombre, String nuevaDescripcion, String nuevoTipo) {
        Producto producto = this.findProducto(idOriginal);

        producto.setNombre(nuevoNombre);
        producto.setDescripcion(nuevaDescripcion);
        producto.setTipo(nuevoTipo);

        this.saveProducto(producto);
    }

    // Baja
    @Override
    public void deleteProducto(Long idProducto) {
        repoProducto.deleteById(idProducto);
    }
}