package com.webminds.project.core.entidades;

import com.webminds.project.infraestructura.entidades.ModoPagoDAO;
import com.webminds.project.infraestructura.entidades.ProductoFacturaDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {
    private Integer facturaID;
    private LocalDate fecha;
    private ModoPagoDAO modoPago;
    private String usuarioID;
    private List<ProductoFacturaDAO> productosEnFactura = new ArrayList<>();
}
