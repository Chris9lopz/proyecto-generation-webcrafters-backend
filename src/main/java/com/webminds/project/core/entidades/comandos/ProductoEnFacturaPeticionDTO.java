package com.webminds.project.core.entidades.comandos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEnFacturaPeticionDTO {
    private Integer productoId;
    private Integer cantidad;

}
