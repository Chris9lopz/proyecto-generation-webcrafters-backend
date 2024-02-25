package com.webminds.project.core.servicios;

import com.webminds.project.core.entidades.FacturaDTO;
import com.webminds.project.core.entidades.comandos.FacturaPeticionDTO;
import com.webminds.project.core.entidades.consultas.FacturaConsultaDTO;
import com.webminds.project.core.excepciones.ModoPagoNoExisteException;
import com.webminds.project.core.excepciones.ProductoNoExisteException;

import java.util.List;
import java.util.Optional;

public interface FacturaServicio {

    List<FacturaConsultaDTO> buscarFacturasPorCliente(String userId);

    Optional<FacturaConsultaDTO> buscarFacturaPorCliente(Integer facturaId, String userId);

    FacturaConsultaDTO crearFactura(FacturaPeticionDTO facturaDTO) throws ModoPagoNoExisteException, ProductoNoExisteException;

    Optional<FacturaDTO> actualizarFactura(FacturaDTO facturaDTO);

    Boolean eliminarFactura(Integer facturaId);
}
