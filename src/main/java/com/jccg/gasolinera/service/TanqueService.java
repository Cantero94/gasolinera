package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Tanque;
import com.jccg.gasolinera.repository.ITanqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TanqueService implements ITanqueService {

    @Autowired
    private ITanqueRepository repoTanque;

    // Lectura de todos los registros
    @Override
    public List<Tanque> getTanques() {
        List<Tanque> listaTanques = repoTanque.findAll();
        return listaTanques;
    }

    // Lectura por ID
    @Override
    public Tanque findTanque(Long idTanque) {
        return repoTanque.findById(idTanque).orElse(null);
    }

    // Alta
    @Override
    public void saveTanque(Tanque tanque) {
        repoTanque.save(tanque);
    }

    // Modificación
    @Override
    public void editTanque(Long idOriginal, Producto nuevoProducto, String nuevoCodigo, Integer nuevaCapacidadMaxima, Integer nuevoNivelActual) {
        Tanque tanque = this.findTanque(idOriginal);

        tanque.setCodigo(nuevoCodigo);
        tanque.setCapacidadMaxima(nuevaCapacidadMaxima);
        tanque.setNivelActual(nuevoNivelActual);
        tanque.setProducto(nuevoProducto);

        this.saveTanque(tanque);
    }

    // Baja
    @Override
    public void deleteTanque(Long idTanque) {
        repoTanque.deleteById(idTanque);
    }
}