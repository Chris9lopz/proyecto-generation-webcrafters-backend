package com.webminds.project.infraestructura.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "modos_pago")
@Data
@NoArgsConstructor
public class ModoPagoDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pagoId;
    private String nombre;

    public ModoPagoDAO(Integer pagoId, String nombre) {
        this.pagoId = pagoId;
        this.nombre = nombre;
    }
}
