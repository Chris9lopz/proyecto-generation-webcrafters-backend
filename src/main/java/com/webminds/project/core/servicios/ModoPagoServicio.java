package com.webminds.project.core.servicios;

import com.webminds.project.core.entidades.ModoPagoDTO;

import java.util.Optional;

public interface ModoPagoServicio {

    Optional<ModoPagoDTO> buscarModoPagoPorId(Integer modoPagoId);
}
