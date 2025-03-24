package com.jccg.gasolinera.controller;

import com.jccg.gasolinera.model.Precio;
import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.service.IPrecioService;
import com.jccg.gasolinera.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PrecioController {

    @Autowired
    private IPrecioService precioService;

    @Autowired
    private IProductoService productoService;

    // Método para traer todos los registros de precios
    @GetMapping("/precios/traer")
    public List<Precio> getPrecios() {
        return precioService.getPrecios();
    }

    // Método para traer un precio por ID
    @GetMapping("/precios/traer/{id}")
    public Precio getPrecio(@PathVariable Long id) {
        return precioService.findPrecio(id);
    }

    // Método para crear un precio
    @PostMapping("/precios/crear")
    public String savePrecio(@RequestBody Precio precio) {
        precioService.savePrecio(precio);
        Long idProducto = precio.getProducto().getIdProducto();
        return "Se ha creado un nuevo precio para el producto con ID " + idProducto + ".";
    }

    // Método para editar por parámetros pasados por URL
    @PutMapping("/precios/editar/{idOriginal}")
    public Precio editPrecio(@PathVariable Long idOriginal,
                             @RequestParam(required = false, name = "idProducto") Long idProducto,
                             @RequestParam(required = false, name = "fechaInicio") String fechaInicio,
                             @RequestParam(required = false, name = "fechaFin") String fechaFin,
                             @RequestParam(required = false, name = "precioPorLitro") BigDecimal precioPorLitro) {

        Precio p = precioService.findPrecio(idOriginal);

        Producto producto = idProducto != null ? productoService.findProducto(idProducto) : p.getProducto();

        LocalDate fechaI = fechaInicio != null ? LocalDate.parse(fechaInicio) : p.getFechaInicio();
        LocalDate fechaF = fechaFin != null ? LocalDate.parse(fechaFin) : p.getFechaFin();
        BigDecimal precio = precioPorLitro != null ? precioPorLitro : p.getPrecioPorLitro();

        precioService.editPrecio(idOriginal, producto, fechaI, fechaF, precio);
        return precioService.findPrecio(idOriginal);
    }

    // Método para editar por parámetros pasados por JSON
    @PutMapping("/precios/editar")
    public Precio editPrecio(@RequestBody Precio precio) {
        precioService.editPrecio(
                precio.getIdPrecio(),
                precio.getProducto(),
                precio.getFechaInicio(),
                precio.getFechaFin(),
                precio.getPrecioPorLitro()
        );

        return precioService.findPrecio(precio.getIdPrecio());
    }

    // Método para borrar un precio
    @DeleteMapping("/precios/borrar/{id}")
    public String deletePrecio(@PathVariable Long id) {
        precioService.deletePrecio(id);
        return "Precio con el id: " + id + " eliminado.";
    }
}