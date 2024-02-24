package com.webminds.project.core.entidades.comandos;

import com.webminds.project.core.entidades.comandos.ProductoEnFacturaPeticionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaPeticionDTO {
    private Integer modoPago;
    private String usuarioId;
    private List<ProductoEnFacturaPeticionDTO> productosEnFactura = new ArrayList<>();
}
