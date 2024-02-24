package com.webminds.project.core.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Integer productoId;
    private String nombre;
    private Double precio;
    private CategoriaDTO categoriaDTO;
    private List<ProductoEnFacturaDTO> productosVendidos = new ArrayList<>();

    public ProductoDTO(Integer productoId, String nombre, Double precio, CategoriaDTO categoriaDTO) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaDTO = categoriaDTO;
    }
}
