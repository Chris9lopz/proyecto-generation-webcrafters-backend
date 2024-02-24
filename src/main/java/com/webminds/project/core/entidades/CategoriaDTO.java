package com.webminds.project.core.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDTO {
    private Integer categoriaId;
    private String nombre;
    private String descripcion;
    private List<ProductoDTO> productos = new ArrayList<>();

    public CategoriaDTO(Integer categoriaId, String nombre, String descripcion) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
