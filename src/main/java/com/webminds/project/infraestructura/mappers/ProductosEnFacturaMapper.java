package com.webminds.project.infraestructura.mappers;

import com.webminds.project.core.entidades.ProductoEnFacturaDTO;
import com.webminds.project.core.entidades.consultas.ProductoEnFacturaConsultaDTO;
import com.webminds.project.infraestructura.entidades.ProductoFacturaDAO;

public class ProductosEnFacturaMapper {
    public static ProductoFacturaDAO pasarAProductoFacturaDAO(ProductoEnFacturaDTO productoEnFacturaDTO) {
        return new ProductoFacturaDAO(productoEnFacturaDTO.getId(),
                FacturaMapper.pasarADAO(productoEnFacturaDTO.getFacturaDTO()),
                ProductoMapper.pasarAProductoDAO(productoEnFacturaDTO.getProductoDTO()),
                productoEnFacturaDTO.getCantidad()
        );
    }

    public static ProductoEnFacturaDTO pasarAProductoEnFacturaDTO(ProductoFacturaDAO productoFacturaDAO) {
        return new ProductoEnFacturaDTO(productoFacturaDAO.getId(),
                FacturaMapper.pasarADTO(productoFacturaDAO.getFacturaDAO()),
                ProductoMapper.pasarAProductoDTO(productoFacturaDAO.getProductoDAO()),
                productoFacturaDAO.getCantidad()
        );
    }

    public static ProductoEnFacturaConsultaDTO pasarAProductoEnFacturaConsultaDTO(ProductoFacturaDAO productoFacturaDAO) {
        return new ProductoEnFacturaConsultaDTO(ProductoMapper.pasarAProductoConsultaDTO(productoFacturaDAO.getProductoDAO()),
                productoFacturaDAO.getCantidad());
    }
}
