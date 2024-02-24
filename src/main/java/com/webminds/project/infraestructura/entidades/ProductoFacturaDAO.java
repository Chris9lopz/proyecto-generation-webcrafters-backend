package com.webminds.project.infraestructura.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "producto_factura")
@Data
@NoArgsConstructor

public class ProductoFacturaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private FacturaDAO facturaDAO;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoDAO productoDAO;

    @Column(name = "cantidad")
    private Integer cantidad;

    public ProductoFacturaDAO(Long id, FacturaDAO facturaDAO, ProductoDAO productoDAO, Integer cantidad) {
        this.id = id;
        this.facturaDAO = facturaDAO;
        this.productoDAO = productoDAO;
        this.cantidad = cantidad;
    }

    public ProductoFacturaDAO(FacturaDAO facturaDAO, ProductoDAO productoDAO, Integer cantidad) {
        this.facturaDAO = facturaDAO;
        this.productoDAO = productoDAO;
        this.cantidad = cantidad;
    }
}
