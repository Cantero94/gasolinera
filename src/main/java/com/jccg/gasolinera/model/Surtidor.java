package com.jccg.gasolinera.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "surtidores")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Surtidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSurtidor;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(name = "fecha_instalacion")
    private LocalDate fechaInstalacion;

    private boolean activo;
    //@JsonIgnore
    @OneToMany(mappedBy = "surtidor", cascade = CascadeType.ALL)
    private List<SurtidorProducto> surtidorProductos = new ArrayList<>();
    //@JsonIgnore
    @OneToMany(mappedBy = "surtidor", cascade = CascadeType.ALL)
    private List<Suministro> suministros = new ArrayList<>();

    //Getter y Setter
    public Long getIdSurtidor() {
        return idSurtidor;
    }

    public void setIdSurtidor(Long idSurtidor) {
        this.idSurtidor = idSurtidor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
}