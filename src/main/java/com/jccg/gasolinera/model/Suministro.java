package com.jccg.gasolinera.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "suministros")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Suministro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuministro;

    @ManyToOne
    @JoinColumn(name = "id_surtidor", nullable = false)
    @JsonIgnore
    private Surtidor surtidor;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    @JsonIgnore
    private Producto producto;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "volumen_litros", nullable = false, precision = 10, scale = 2)
    private BigDecimal volumenLitros;

    @Column(name = "importe_euros", nullable = false, precision = 10, scale = 2)
    private BigDecimal importeEuros;

    // Getter y Setter
    public Long getIdSuministro() {
        return idSuministro;
    }

    public void setIdSuministro(Long idSuministro) {
        this.idSuministro = idSuministro;
    }

    public Surtidor getSurtidor() {
        return surtidor;
    }

    public void setSurtidor(Surtidor surtidor) {
        this.surtidor = surtidor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getVolumenLitros() {
        return volumenLitros;
    }

    public void setVolumenLitros(BigDecimal volumenLitros) {
        this.volumenLitros = volumenLitros;
    }

    public BigDecimal getImporteEuros() {
        return importeEuros;
    }

    public void setImporteEuros(BigDecimal importeEuros) {
        this.importeEuros = importeEuros;
    }
}