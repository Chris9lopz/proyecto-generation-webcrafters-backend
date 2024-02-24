package com.webminds.project.core.entidades.consultas;

import com.webminds.project.core.entidades.ProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEnFacturaConsultaDTO {
    private ProductoDTO productoDTO;
    private Integer cantidad;
}
