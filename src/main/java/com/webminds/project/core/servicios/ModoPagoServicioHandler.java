package com.webminds.project.core.servicios;

import com.webminds.project.core.entidades.ModoPagoDTO;
import com.webminds.project.infraestructura.mappers.ModoPagoMapper;
import com.webminds.project.infraestructura.repository.ModoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModoPagoServicioHandler implements ModoPagoServicio{

    private final ModoPagoRepository modoPagoRepository;

    public ModoPagoServicioHandler(ModoPagoRepository modoPagoRepository) {
        this.modoPagoRepository = modoPagoRepository;
    }

    @Override
    public Optional<ModoPagoDTO> buscarModoPagoPorId(Integer modoPagoId) {
        return modoPagoRepository.findById(modoPagoId).map(ModoPagoMapper::pasarAModoPagoDTO);
    }
}
