package com.jccg.gasolinera.controller;

import com.jccg.gasolinera.model.Producto;
import com.jccg.gasolinera.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // Método para traer todos los registros de productos
    @GetMapping("/productos/traer")
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    // Método para traer un producto por ID
    @GetMapping("/productos/traer/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productoService.findProducto(id);
    }

    // Método para crear un producto
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return "Se ha creado un nuevo producto.";
    }

    // Método para editar por parámetros pasados por URL
    @PutMapping("/productos/editar/{idOriginal}")
    public Producto editProducto(@PathVariable Long idOriginal,
                                 @RequestParam(required = false, name = "nombre") String nuevoNombre,
                                 @RequestParam(required = false, name = "descripcion") String nuevaDescripcion,
                                 @RequestParam(required = false, name = "tipo") String nuevoTipo) {

        Producto p = productoService.findProducto(idOriginal);
        String nombre = nuevoNombre != null ? nuevoNombre : p.getNombre();
        String descripcion = nuevaDescripcion != null ? nuevaDescripcion : p.getDescripcion();
        String tipo = nuevoTipo != null ? nuevoTipo : p.getTipo();

        productoService.editProducto(idOriginal, nombre, descripcion, tipo);
        return productoService.findProducto(idOriginal);
    }

    // Método para editar por parámetros pasados por JSON
    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto producto) {
        productoService.editProducto(
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getTipo()
        );
        return productoService.findProducto(producto.getIdProducto());
    }

    // Método para borrar un producto
    @DeleteMapping("/productos/borrar/{id}")
    public String deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "Producto con el id: " + id + " eliminado.";
    }
}