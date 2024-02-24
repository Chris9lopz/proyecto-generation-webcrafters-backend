package com.webminds.project.infraestructura.mappers;

import com.webminds.project.core.entidades.ModoPagoDTO;
import com.webminds.project.infraestructura.entidades.ModoPagoDAO;

public class ModoPagoMapper {

    public static ModoPagoDTO pasarAModoPagoDTO(ModoPagoDAO modoPagoDAO) {
        return new ModoPagoDTO(modoPagoDAO.getPagoId(), modoPagoDAO.getNombre());
    }

    public static ModoPagoDAO pasarAModoPagoDAO(ModoPagoDTO modoPagoDTO) {
        return new ModoPagoDAO(modoPagoDTO.getModoPagoId(),modoPagoDTO.getNombre());
    }
}
