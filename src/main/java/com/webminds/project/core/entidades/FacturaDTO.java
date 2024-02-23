package com.webminds.project.core.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private Integer facturaID;
    private LocalDate fecha;
    private Integer pagoID;
    private String usuarioID;

}
