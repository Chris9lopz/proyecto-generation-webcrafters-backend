package com.webminds.project.infraestructura.mappers;

import com.webminds.project.core.entidades.ProductoDTO;
import com.webminds.project.infraestructura.entidades.ProductoDAO;

public class ProductoMapper {
    public static ProductoDAO pasarAProductoDAO(ProductoDTO productoDTO) {
        return new ProductoDAO(productoDTO.getProductoId(),
                productoDTO.getNombre(),
                productoDTO.getPrecio(),
                CategoriaMapper.pasarACategoriaDAO(productoDTO.getCategoriaDTO()));
              //  productoDTO.getProductosVendidos().stream().map(ProductosEnFacturaMapper::pasarAProductoFacturaDAO).toList());
    }



    public static ProductoDTO pasarAProductoDTO(ProductoDAO productoDAO) {
        return new ProductoDTO(productoDAO.getProductoId(),
                productoDAO.getNombre(),
                productoDAO.getPrecio(),
                CategoriaMapper.pasarACategoriaDTO(productoDAO.getCategoriaDAO()));
               // productoDAO.getProductosVendidos().stream().map(ProductosEnFacturaMapper::pasarAProductoEnFacturaDTO).toList());
    }


}
