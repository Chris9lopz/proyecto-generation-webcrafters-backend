package com.webminds.project.core.entidades.consultas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaConsultaDTO {

    private Integer facturaId;

    private LocalDate fecha;

    private String modoPago;

    private String usuarioId;

    private Double precioTotal;


    private List<ProductoEnFacturaConsultaDTO> productosEnFactura = new ArrayList<>();
}
