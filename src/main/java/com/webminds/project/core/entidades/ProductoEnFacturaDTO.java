package com.webminds.project.core.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEnFacturaDTO {
    private Long id;
    private FacturaDTO facturaDTO;
    private ProductoDTO productoDTO;
    private Integer cantidad;
}
