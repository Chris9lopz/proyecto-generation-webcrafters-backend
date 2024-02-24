package com.webminds.project.infraestructura.repository;

import com.webminds.project.infraestructura.entidades.ProductoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<ProductoDAO,Integer> {
}
