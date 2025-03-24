package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Precio;
import com.jccg.gasolinera.model.Producto;

import com.jccg.gasolinera.repository.IPrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PrecioService implements IPrecioService {

    @Autowired
    private IPrecioRepository repoPrecio;

    // Lectura de todos los registros
    @Override
    public List<Precio> getPrecios() {
        List<Precio> listaPrecios = repoPrecio.findAll();
        return listaPrecios;
    }

    // Lectura por ID
    @Override
    public Precio findPrecio(Long idPrecio) {
        return repoPrecio.findById(idPrecio).orElse(null);
    }

    // Alta
    @Override
    public void savePrecio(Precio precio) {
        repoPrecio.save(precio);
    }

    // Modificación
    @Override
    public void editPrecio(Long idOriginal, Producto nuevoProducto, LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, BigDecimal nuevoPrecioPorLitro) {
        Precio precio = this.findPrecio(idOriginal);

        precio.setProducto(nuevoProducto);
        precio.setFechaInicio(nuevaFechaInicio);
        precio.setFechaFin(nuevaFechaFin);
        precio.setPrecioPorLitro(nuevoPrecioPorLitro);

        this.savePrecio(precio);
    }

    // Baja
    @Override
    public void deletePrecio(Long idPrecio) {
        repoPrecio.deleteById(idPrecio);
    }
}


