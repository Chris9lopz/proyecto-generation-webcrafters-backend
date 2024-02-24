package com.webminds.project.core.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModoPagoDTO {
    private Integer modoPagoId;
    private String nombre;
}
