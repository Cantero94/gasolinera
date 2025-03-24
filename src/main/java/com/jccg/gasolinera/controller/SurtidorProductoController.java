package com.jccg.gasolinera.controller;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.model.Surtidor;
import com.jccg.gasolinera.model.SurtidorProducto;
import com.jccg.gasolinera.service.IProductoService;
import com.jccg.gasolinera.service.ISurtidorProductoService;
import com.jccg.gasolinera.service.ISurtidorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SurtidorProductoController {

    @Autowired
    private ISurtidorProductoService surtidorProductoService;

    @Autowired
    private ISurtidorService surtidorService;

    @Autowired
    private IProductoService productoService;

    // Método para traer todos los registros de la relación surtidor-producto
    @GetMapping("/surtidor-productos/traer")
    public List<SurtidorProducto> getSurtidorProductos() {
        return surtidorProductoService.getSurtidorProductos();
    }

    // Método para traer una relación surtidor-producto por ID
    @GetMapping("/surtidor-productos/traer/{id}")
    public SurtidorProducto getSurtidorProducto(@PathVariable Long id) {
        return surtidorProductoService.findSurtidorProducto(id);
    }

    // Método para crear una relación surtidor-producto
    @PostMapping("/surtidor-productos/crear")
    public String saveSurtidorProducto(@RequestBody SurtidorProducto surtidorProducto) {
        surtidorProductoService.saveSurtidorProducto(surtidorProducto);
        Long idProducto = surtidorProducto.getProducto().getIdProducto();
        Long idSurtidor = surtidorProducto.getSurtidor().getIdSurtidor();
        return "Se ha creado una relación entre el surtidor: " + idSurtidor + " y el producto: " + idProducto;
    }

    // Método para editar por parámetros pasados por URL
    @PutMapping("/surtidor-productos/editar/{idOriginal}")
    public SurtidorProducto editSurtidorProducto(@PathVariable Long idOriginal,
                                                 @RequestParam(required = false, name = "idSurtidor") Long idSurtidor,
                                                 @RequestParam(required = false, name = "idProducto") Long idProducto) {

        Surtidor surtidor = idSurtidor != null ? surtidorService.findSurtidor(idSurtidor) : null;
        Producto producto = idProducto != null ? productoService.findProducto(idProducto) : null;

        surtidorProductoService.editSurtidorProducto(idOriginal, surtidor, producto);

        return surtidorProductoService.findSurtidorProducto(idOriginal);
    }

    // Método para editar por parámetros pasados por JSON
    @PutMapping("/surtidor-productos/editar")
    public SurtidorProducto editSurtidorProducto(@RequestBody SurtidorProducto surtidorProducto) {
        surtidorProductoService.editSurtidorProducto(
                surtidorProducto.getIdSurtidorProducto(),
                surtidorProducto.getSurtidor(),
                surtidorProducto.getProducto()
        );

        return surtidorProductoService.findSurtidorProducto(surtidorProducto.getIdSurtidorProducto());
    }

    // Método para borrar una relación surtidor-producto
    @DeleteMapping("/surtidor-productos/borrar/{id}")
    public String deleteSurtidorProducto(@PathVariable Long id) {
        surtidorProductoService.deleteSurtidorProducto(id);
        return "La relación surtidor-producto con el id: " + id + " eliminada.";
    }
}