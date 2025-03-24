package com.jccg.gasolinera.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tanques")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Tanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTanque;

    @Column(nullable = true, unique = true)
    private String codigo;

    @Column(name = "capacidad_maxima", nullable = false)
    private Integer capacidadMaxima;

    @Column(name = "nivel_actual", nullable = false)
    private Integer nivelActual;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    // Getter y Setter
    public Long getIdTanque() {
        return idTanque;
    }

    public void setIdTanque(Long idTanque) {
        this.idTanque = idTanque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Integer getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(Integer nivelActual) {
        this.nivelActual = nivelActual;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}