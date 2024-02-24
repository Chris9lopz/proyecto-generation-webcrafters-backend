package com.webminds.project.infraestructura.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "facturas")
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facturaId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "America/Bogota")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "modo_pago_id")
    private ModoPagoDAO modoPagoDAO;

    private String usuarioId;

    @OneToMany(mappedBy = "facturaDAO")
    private List<ProductoFacturaDAO> productosEnFactura = new ArrayList<>();

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ModoPagoDAO getModoPagoDAO() {
        return modoPagoDAO;
    }

    public void setModoPagoDAO(ModoPagoDAO modoPagoDAO) {
        this.modoPagoDAO = modoPagoDAO;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ProductoFacturaDAO> getProductosEnFactura() {
        return productosEnFactura;
    }

    public void setProductosEnFactura(List<ProductoFacturaDAO> productosEnFactura) {
        this.productosEnFactura = productosEnFactura;
    }
}
