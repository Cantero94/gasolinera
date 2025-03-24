package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Surtidor;
import com.jccg.gasolinera.repository.ISurtidorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class SurtidorService implements ISurtidorService {

    @Autowired
    private ISurtidorRepository repoSurtidor;

    // Lectura de todos los registros
    @Override
    public List<Surtidor> getSurtidores() {
        List<Surtidor> listaSurtidores = repoSurtidor.findAll();
        return listaSurtidores;
    }

    // Lectura por ID
    @Override
    public Surtidor findSurtidor(Long idSurtidor) {
        return repoSurtidor.findById(idSurtidor).orElse(null);
    }

    // Alta
    @Override
    public void saveSurtidor(Surtidor surtidor) {
        repoSurtidor.save(surtidor);
    }

    // Modificación
    @Override
    public void editSurtidor(Long idOriginal, String nuevoCodigo, LocalDate nuevaFechaInstalacion, boolean nuevoActivo) {
        Surtidor surtidor = this.findSurtidor(idOriginal);

        surtidor.setCodigo(nuevoCodigo);
        surtidor.setFechaInstalacion(nuevaFechaInstalacion);
        surtidor.setActivo(nuevoActivo);

        this.saveSurtidor(surtidor);
    }

    // Baja
    @Override
    public void deleteSurtidor(Long idSurtidor) {
        repoSurtidor.deleteById(idSurtidor);
    }
}