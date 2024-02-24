package com.webminds.project.infraestructura.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;
    @Column(unique = true)
    private String nombre;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaDAO categoriaDAO;

    @OneToMany(mappedBy = "productoDAO")
    private List<ProductoFacturaDAO> productosVendidos = new ArrayList<>();

    public ProductoDAO(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoDAO(Integer productoId, String nombre, Double precio, CategoriaDAO categoriaDAO) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaDAO = categoriaDAO;
    }
}
