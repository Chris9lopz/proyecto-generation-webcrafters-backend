package com.webminds.project.infraestructura.repository;

import com.webminds.project.infraestructura.entidades.ModoPagoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoPagoRepository extends JpaRepository<ModoPagoDAO, Integer>{
}
