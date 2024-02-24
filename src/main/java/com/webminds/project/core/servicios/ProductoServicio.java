package com.webminds.project.core.servicios;

import com.webminds.project.core.entidades.ProductoDTO;

import java.util.List;
import java.util.Optional;

public interface ProductoServicio {
    List<ProductoDTO> buscarProductos();
    Optional<ProductoDTO> buscarProductoPorId(Integer productoId);
}
