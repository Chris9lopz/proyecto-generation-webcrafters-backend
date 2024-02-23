package com.webminds.project.infraestructura.mappers;

import com.webminds.project.core.entidades.FacturaDTO;
import com.webminds.project.infraestructura.entidades.FacturaDAO;

public class FacturaMapper {
    public static FacturaDTO pasarADTO(FacturaDAO factura) {
        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setFacturaID(factura.getFacturaID());
        facturaDTO.setFecha(factura.getFecha());
        facturaDTO.setPagoID(factura.getPagoID());
        facturaDTO.setUsuarioID(factura.getUsuarioID());
        return facturaDTO;
    }
    public static FacturaDAO pasarADAO(FacturaDTO facturaDTO) {
        FacturaDAO factura = new FacturaDAO();
        factura.setFacturaID(facturaDTO.getFacturaID());
        factura.setFecha(facturaDTO.getFecha());
        factura.setPagoID(facturaDTO.getPagoID());
        factura.setUsuarioID(facturaDTO.getUsuarioID());
        return factura;
    }
}
