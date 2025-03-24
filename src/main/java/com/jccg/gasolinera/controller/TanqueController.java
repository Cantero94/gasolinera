package com.jccg.gasolinera.controller;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Tanque;
import com.jccg.gasolinera.service.ITanqueService;
import com.jccg.gasolinera.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TanqueController {

    @Autowired
    private ITanqueService tanqueService;

    @Autowired
    private IProductoService productoService;

    // Método para traer todos los registros de tanques
    @GetMapping("/tanques/traer")
    public List<Tanque> getTanques() {
        return tanqueService.getTanques();
    }

    // Método para traer un tanque por ID
    @GetMapping("/tanques/traer/{id}")
    public Tanque getTanque(@PathVariable Long id) {
        return tanqueService.findTanque(id);
    }

    // Método para crear un tanque
    @PostMapping("/tanques/crear")
    public String saveTanque(@RequestBody Tanque tanque) {
        tanqueService.saveTanque(tanque);
        return "Se ha creado un nuevo tanque.";
    }

    // Método para editar por parámetros pasados por URL
    @PutMapping("/tanques/editar/{idOriginal}")
    public Tanque editTanque(@PathVariable Long idOriginal,
                             @RequestParam(required = false, name = "idProducto") Long idProducto,
                             @RequestParam(required = false, name = "codigo") String nuevoCodigo,
                             @RequestParam(required = false, name = "capacidadMaxima") Integer nuevaCapacidadMaxima,
                             @RequestParam(required = false, name = "nivelActual") Integer nuevoNivelActual)
                             {

        Producto producto = idProducto != null ? productoService.findProducto(idProducto) : null;

        Tanque t = tanqueService.findTanque(idOriginal);
        if (nuevoCodigo==null) nuevoCodigo=t.getCodigo();
        if (nuevaCapacidadMaxima==null) nuevaCapacidadMaxima=t.getCapacidadMaxima();
        if (nuevoNivelActual==null) nuevoNivelActual=t.getNivelActual();
        if (producto==null) producto=t.getProducto();

        tanqueService.editTanque(idOriginal, producto, nuevoCodigo, nuevaCapacidadMaxima, nuevoNivelActual);

        return tanqueService.findTanque(idOriginal);
    }

    // Método para editar por parámetros pasados por JSON
    @PutMapping("/tanques/editar")
    public Tanque editTanque(@RequestBody Tanque tanque) {
        tanqueService.editTanque(
                tanque.getIdTanque(),
                tanque.getProducto(),
                tanque.getCodigo(),
                tanque.getCapacidadMaxima(),
                tanque.getNivelActual()
        );

        return tanqueService.findTanque(tanque.getIdTanque());
    }

    // Método para borrar un tanque
    @DeleteMapping("/tanques/borrar/{id}")
    public String deleteTanque(@PathVariable Long id) {
        tanqueService.deleteTanque(id);
        return "Tanque con el id: " + id + " eliminado.";
    }
}