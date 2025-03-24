package com.jccg.gasolinera.controller;

import com.jccg.gasolinera.model.Surtidor;
import com.jccg.gasolinera.service.ISurtidorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SurtidorController {

    @Autowired
    private ISurtidorService surtidorService;

    // Método para traer todos los registros de surtidores
    @GetMapping("/surtidores/traer")
    public List<Surtidor> getSurtidores() {
        return surtidorService.getSurtidores();
    }

    // Método para traer un surtidor por ID
    @GetMapping("/surtidores/traer/{id}")
    public Surtidor getSurtidor(@PathVariable Long id) {
        return surtidorService.findSurtidor(id);
    }

    // Método para crear un surtidor
    @PostMapping("/surtidores/crear")
    public String saveSurtidor(@RequestBody Surtidor surtidor) {
        surtidorService.saveSurtidor(surtidor);
        return "Se ha creado un nuevo surtidor.";
    }

    // Método para editar por parámetros pasados por URL
    @PutMapping("/surtidores/editar/{idOriginal}")
    public Surtidor editSurtidor(@PathVariable Long idOriginal,
                                 @RequestParam(required = false, name = "codigo") String nuevoCodigo,
                                 @RequestParam(required = false, name = "fechaInstalacion") String nuevaFechaInstalacion,
                                 @RequestParam(required = false, name = "activo") Boolean nuevoActivo) {

        Surtidor s = surtidorService.findSurtidor(idOriginal);

        String codigo = nuevoCodigo != null ? nuevoCodigo : s.getCodigo();
        LocalDate fechaInst = nuevaFechaInstalacion != null ? LocalDate.parse(nuevaFechaInstalacion) : s.getFechaInstalacion();
        Boolean activo = nuevoActivo != null ? nuevoActivo : s.isActivo();

        surtidorService.editSurtidor(idOriginal, codigo, fechaInst, activo);

        return surtidorService.findSurtidor(idOriginal);
    }

    // Método para editar por parámetros pasados por JSON
    @PutMapping("/surtidores/editar")
    public Surtidor editSurtidor(@RequestBody Surtidor surtidor) {
        surtidorService.editSurtidor(
                surtidor.getIdSurtidor(),
                surtidor.getCodigo(),
                surtidor.getFechaInstalacion(),
                surtidor.isActivo()
        );

        return surtidorService.findSurtidor(surtidor.getIdSurtidor());
    }

    // Método para borrar un surtidor
    @DeleteMapping("/surtidores/borrar/{id}")
    public String deleteSurtidor(@PathVariable Long id) {
        surtidorService.deleteSurtidor(id);
        return "Surtidor con el id: " + id + " eliminado.";
    }
}