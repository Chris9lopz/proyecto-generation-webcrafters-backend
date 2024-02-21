package com.webminds.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Factura {
    @Id
    @GeneratedValue
    private Integer facturaID;
    private LocalDate fecha;
    private Integer pagoID;
    private Integer usuarioID;
}
