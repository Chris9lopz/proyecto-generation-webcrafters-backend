package com.webminds.project.infraestructura.repository;

import com.webminds.project.infraestructura.entidades.FacturaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FacturaRepository extends JpaRepository<FacturaDAO, Integer> {
    @Query("SELECT f FROM factura f WHERE f.usuarioID = ?1")
    List<FacturaDAO> buscarFacturasPorCliente(String userId);
    @Query("SELECT f FROM factura f WHERE f.facturaID = ?1 AND f.usuarioID = ?2")
    Optional<FacturaDAO> buscarFacturaPorCliente(Integer facturaId, String userId);
    @Query("SELECT f FROM factura f WHERE f.facturaID = ?1")
    Optional<FacturaDAO> buscarFacturaPorIdDeFactura(Integer facturaId);
}
