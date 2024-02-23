package com.webminds.project.infraestructura.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pagoID;
    private String nombre;
}
