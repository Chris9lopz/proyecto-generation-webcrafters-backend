package com.webminds.project.infraestructura.mappers;

import com.webminds.project.core.entidades.CategoriaDTO;
import com.webminds.project.infraestructura.entidades.CategoriaDAO;

public class CategoriaMapper {
    public static CategoriaDAO pasarACategoriaDAO(CategoriaDTO categoriaDTO) {
        return new CategoriaDAO(categoriaDTO.getCategoriaId(),
                categoriaDTO.getNombre(),
                categoriaDTO.getDescripcion(),
                categoriaDTO.getProductos().stream().map(ProductoMapper::pasarAProductoDAO).toList());
    }

    public static CategoriaDTO pasarACategoriaDTO(CategoriaDAO categoriaDAO) {
        return new CategoriaDTO(categoriaDAO.getCategoriaId(),
                categoriaDAO.getNombre(),
                categoriaDAO.getDescripcion());
    }

}
