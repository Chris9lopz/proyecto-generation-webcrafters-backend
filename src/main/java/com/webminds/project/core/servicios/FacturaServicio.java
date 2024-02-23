package com.webminds.project.core.servicios;

import com.webminds.project.core.entidades.FacturaDTO;

import java.util.List;
import java.util.Optional;

public interface FacturaServicio {

    List<FacturaDTO> buscarFacturasPorCliente(String userId);

    Optional<FacturaDTO> buscarFacturaPorCliente(Integer facturaId, String userId);

    FacturaDTO crearFactura(FacturaDTO facturaDTO);

    Optional<FacturaDTO> actualizarFactura(FacturaDTO facturaDTO);

    Boolean eliminarFactura(Integer facturaId);
}
