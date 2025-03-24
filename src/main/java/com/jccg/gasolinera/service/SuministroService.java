package com.jccg.gasolinera.service;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Suministro;
import com.jccg.gasolinera.model.Surtidor;
import com.jccg.gasolinera.repository.ISuministroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuministroService implements ISuministroService {

    @Autowired
    private ISuministroRepository repoSuministro;

    // Lectura de todos los registros
    @Override
    public List<Suministro> getSuministros() {
        List<Suministro> listaSuministros = repoSuministro.findAll();
        return listaSuministros;
    }

    // Lectura por ID
    @Override
    public Suministro findSuministro(Long idSuministro) {
        return repoSuministro.findById(idSuministro).orElse(null);
    }

    // Alta
    @Override
    public void saveSuministro(Suministro suministro) {
        repoSuministro.save(suministro);
    }

    // Modificación
    @Override
    public void editSuministro(Long idOriginal, Surtidor nuevoSurtidor, Producto nuevoProducto, LocalDateTime nuevaFechaHora, BigDecimal nuevoVolumenLitros, BigDecimal nuevoImporteEuros) {
        Suministro suministro = this.findSuministro(idOriginal);

        suministro.setSurtidor(nuevoSurtidor);
        suministro.setProducto(nuevoProducto);
        suministro.setFechaHora(nuevaFechaHora);
        suministro.setVolumenLitros(nuevoVolumenLitros);
        suministro.setImporteEuros(nuevoImporteEuros);

        this.saveSuministro(suministro);
    }

    // Baja
    @Override
    public void deleteSuministro(Long idSuministro) {
        repoSuministro.deleteById(idSuministro);
    }
}