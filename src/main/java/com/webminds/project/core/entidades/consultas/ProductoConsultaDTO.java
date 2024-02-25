package com.webminds.project.core.entidades.consultas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductoConsultaDTO {
    private Integer productoId;
    private String nombre;
    private Double precio;
    private String categoriaNombre;
}
