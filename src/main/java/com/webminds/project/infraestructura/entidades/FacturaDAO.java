package com.webminds.project.infraestructura.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facturaID;
    private LocalDate fecha;
    private Integer pagoID;
    private String usuarioID;
}
