package com.webminds.project.core.entidades.consultas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEnFacturaConsultaDTO {
    @JsonProperty("producto")
    private ProductoConsultaDTO productoConsultaDTO;
    private Integer cantidad;
}
