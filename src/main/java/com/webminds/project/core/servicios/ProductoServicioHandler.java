package com.webminds.project.core.servicios;

import com.webminds.project.core.entidades.ProductoDTO;
import com.webminds.project.infraestructura.mappers.ProductoMapper;
import com.webminds.project.infraestructura.repository.ProductoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServicioHandler implements ProductoServicio{

    private final ProductoRepositorio productoRepositorio;

    public ProductoServicioHandler(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public List<ProductoDTO> buscarProductos() {
        return productoRepositorio.findAll().stream().map(ProductoMapper::pasarAProductoDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoDTO> buscarProductoPorId(Integer productoId) {
        return productoRepositorio.findById(productoId).map(ProductoMapper::pasarAProductoDTO);
    }
}
