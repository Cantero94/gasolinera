package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Surtidor;
import com.jccg.gasolinera.model.SurtidorProducto;
import com.jccg.gasolinera.repository.ISurtidorProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SurtidorProductoService implements ISurtidorProductoService {

    @Autowired
    private ISurtidorProductoRepository repoSurtidorProducto;

    // Lectura de todos los registros
    @Override
    public List<SurtidorProducto> getSurtidorProductos() {
        List<SurtidorProducto> listaSurtidorProductos = repoSurtidorProducto.findAll();
        return listaSurtidorProductos;
    }

    // Lectura por ID
    @Override
    public SurtidorProducto findSurtidorProducto(Long idSurtidorProducto) {
        return repoSurtidorProducto.findById(idSurtidorProducto).orElse(null);
    }

    // Alta
    @Override
    public void saveSurtidorProducto(SurtidorProducto surtidorProducto) {
        repoSurtidorProducto.save(surtidorProducto);
    }

    // Modificación
    @Override
    public void editSurtidorProducto(Long idOriginal, Surtidor nuevoSurtidor, Producto nuevoProducto) {
        SurtidorProducto surtidorProducto = this.findSurtidorProducto(idOriginal);

        surtidorProducto.setSurtidor(nuevoSurtidor);
        surtidorProducto.setProducto(nuevoProducto);

        this.saveSurtidorProducto(surtidorProducto);
    }

    // Baja
    @Override
    public void deleteSurtidorProducto(Long idSurtidorProducto) {
        repoSurtidorProducto.deleteById(idSurtidorProducto);
    }
}