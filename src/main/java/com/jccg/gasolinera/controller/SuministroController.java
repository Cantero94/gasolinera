package com.jccg.gasolinera.controller;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Suministro;
import com.jccg.gasolinera.model.Surtidor;
import com.jccg.gasolinera.service.IProductoService;
import com.jccg.gasolinera.service.ISuministroService;
import com.jccg.gasolinera.service.ISurtidorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SuministroController {

    @Autowired
    private ISuministroService suministroService;

    @Autowired
    private ISurtidorService surtidorService;

    @Autowired
    private IProductoService productoService;

    // Método para traer todos los registros de suministros
    @GetMapping("/suministros/traer")
    public List<Suministro> getSuministros() {
        return suministroService.getSuministros();
    }

    // Método para traer un suministro por ID
    @GetMapping("/suministros/traer/{id}")
    public Suministro getSuministro(@PathVariable Long id) {
        return suministroService.findSuministro(id);
    }

    // Método para crear un suministro
    @PostMapping("/suministros/crear")
    public String saveSuministro(@RequestBody Suministro suministro) {
        suministroService.saveSuministro(suministro);
        Long idProducto = suministro.getProducto().getIdProducto();
        return "Se ha creado un nuevo suministro para el producto: " + idProducto;
    }

    // Método para editar por parámetros pasados por URL
    @PutMapping("/suministros/editar/{idOriginal}")
    public Suministro editSuministro(@PathVariable Long idOriginal,
                                     @RequestParam(required = false, name = "idSurtidor") Long idSurtidor,
                                     @RequestParam(required = false, name = "idProducto") Long idProducto,
                                     @RequestParam(required = false, name = "fechaHora") String fechaHora,
                                     @RequestParam(required = false, name = "volumenLitros") BigDecimal volumenLitros,
                                     @RequestParam(required = false, name = "importeEuros") BigDecimal importeEuros) {

        Suministro s = suministroService.findSuministro(idOriginal);

        Surtidor surtidor = idSurtidor != null ? surtidorService.findSurtidor(idSurtidor) : s.getSurtidor();
        Producto producto = idProducto != null ? productoService.findProducto(idProducto) : s.getProducto();
        LocalDateTime fechaHoraFormateada = fechaHora != null ? LocalDateTime.parse(fechaHora, DateTimeFormatter.ISO_DATE_TIME) : s.getFechaHora();
        BigDecimal volumen = volumenLitros != null ? volumenLitros : s.getVolumenLitros();
        BigDecimal importe = importeEuros != null ? importeEuros : s.getImporteEuros();

        suministroService.editSuministro(idOriginal, surtidor, producto, fechaHoraFormateada, volumen, importe);
        return suministroService.findSuministro(idOriginal);
    }

    // Método para editar por parámetros pasados por JSON
    @PutMapping("/suministros/editar")
    public Suministro editSuministro(@RequestBody Suministro suministro) {
        suministroService.editSuministro(
                suministro.getIdSuministro(),
                suministro.getSurtidor(),
                suministro.getProducto(),
                suministro.getFechaHora(),
                suministro.getVolumenLitros(),
                suministro.getImporteEuros()
        );
        return suministroService.findSuministro(suministro.getIdSuministro());
    }

    // Método para borrar un suministro
    @DeleteMapping("/suministros/borrar/{id}")
    public String deleteSuministro(@PathVariable Long id) {
        suministroService.deleteSuministro(id);
        return "Suministro con el id: " + id + " eliminado.";
    }
}