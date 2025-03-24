package com.jccg.gasolinera.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    private String tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Precio> precios = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<SurtidorProducto> surtidorProductos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Suministro> suministros = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Tanque> tanques = new ArrayList<>();

    // Getter y Setter
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Precio> getPrecios() {
        return precios;
    }

    public void setPrecios(List<Precio> precios) {
        this.precios = precios;
    }

    public List<SurtidorProducto> getSurtidorProductos() {
        return surtidorProductos;
    }

    public void setSurtidorProductos(List<SurtidorProducto> surtidorProductos) {
        this.surtidorProductos = surtidorProductos;
    }

    public List<Suministro> getSuministros() {
        return suministros;
    }

    public void setSuministros(List<Suministro> suministros) {
        this.suministros = suministros;
    }

    public List<Tanque> getTanques() {
        return tanques;
    }

    public void setTanques(List<Tanque> tanques) {
        this.tanques = tanques;
    }
}