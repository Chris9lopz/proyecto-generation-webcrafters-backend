package com.webminds.project.infraestructura.repository;

import com.webminds.project.infraestructura.entidades.ProductoFacturaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoEnFacturaRepositorio extends JpaRepository<ProductoFacturaDAO,Integer> {
}
