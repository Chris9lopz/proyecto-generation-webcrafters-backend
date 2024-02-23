package com.webminds.project.core.servicios;

import com.webminds.project.core.entidades.FacturaDTO;
import com.webminds.project.infraestructura.mappers.FacturaMapper;
import com.webminds.project.infraestructura.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacturaServicioHandler implements FacturaServicio {

    private final FacturaRepository facturaRepository;

    public FacturaServicioHandler(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<FacturaDTO> buscarFacturasPorCliente(String userId) {
        return facturaRepository
                .buscarFacturasPorCliente(userId)
                .stream()
                .map(FacturaMapper::pasarADTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FacturaDTO> buscarFacturaPorCliente(Integer facturaId, String userId) {
        return facturaRepository.buscarFacturaPorCliente(facturaId, userId).map(FacturaMapper::pasarADTO);
    }

    @Override
    public FacturaDTO crearFactura(FacturaDTO facturaDTO) {
        return FacturaMapper.pasarADTO(facturaRepository.save(FacturaMapper.pasarADAO(facturaDTO)));
    }

    @Override
    public Optional<FacturaDTO> actualizarFactura(FacturaDTO facturaDTO) {
        return facturaRepository
                .buscarFacturaPorCliente(facturaDTO.getFacturaID(), facturaDTO.getUsuarioID())
                .map(facturaDAO -> FacturaMapper.pasarADTO(facturaRepository.save(FacturaMapper.pasarADAO(facturaDTO))));
    }

    @Override
    public Boolean eliminarFactura(Integer facturaId) {
        return facturaRepository.buscarFacturaPorIdDeFactura(facturaId)
                .map(facturaDAO -> {
                    facturaRepository.deleteById(facturaId);
                    return true;
                }
        ).orElse(false);
    }
}
