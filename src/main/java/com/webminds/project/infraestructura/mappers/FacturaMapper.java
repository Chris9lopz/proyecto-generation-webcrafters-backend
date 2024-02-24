package com.webminds.project.infraestructura.mappers;

import com.webminds.project.core.entidades.FacturaDTO;
import com.webminds.project.core.entidades.consultas.FacturaConsultaDTO;
import com.webminds.project.infraestructura.entidades.FacturaDAO;

public class FacturaMapper {
    public static FacturaDTO pasarADTO(FacturaDAO factura) {
        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setFacturaID(factura.getFacturaId());
        facturaDTO.setFecha(factura.getFecha());
        facturaDTO.setModoPago(factura.getModoPagoDAO());
        facturaDTO.setUsuarioID(factura.getUsuarioId());
        return facturaDTO;
    }
    public static FacturaDAO pasarADAO(FacturaDTO facturaDTO) {
        FacturaDAO factura = new FacturaDAO();
        factura.setFacturaId(facturaDTO.getFacturaID());
        factura.setFecha(facturaDTO.getFecha());
        factura.setModoPagoDAO(facturaDTO.getModoPago());
        factura.setUsuarioId(facturaDTO.getUsuarioID());
        return factura;
    }

    public static FacturaConsultaDTO pasarAConsultaDTO(FacturaDAO facturaDAO) {
        FacturaConsultaDTO facturaConsultaDTO =  new FacturaConsultaDTO();
        facturaConsultaDTO.setFacturaId(facturaDAO.getFacturaId());
        facturaConsultaDTO.setFecha(facturaDAO.getFecha());
        facturaConsultaDTO.setModoPago(facturaDAO.getModoPagoDAO().getNombre());
        facturaConsultaDTO.setUsuarioId(facturaDAO.getUsuarioId());
        facturaConsultaDTO.setProductosEnFactura(facturaDAO
                .getProductosEnFactura()
                .stream()
                .map(ProductosEnFacturaMapper::pasarAProductoEnFacturaConsultaDTO)
                .toList());
        facturaConsultaDTO.setPrecioTotal(facturaDAO.getProductosEnFactura().stream().mapToDouble((productoFacturaDAO)->
                productoFacturaDAO.getProductoDAO().getPrecio()*productoFacturaDAO.getCantidad()).sum());
        return facturaConsultaDTO;
    }
}
