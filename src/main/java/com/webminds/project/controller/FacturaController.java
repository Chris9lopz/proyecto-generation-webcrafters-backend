package com.webminds.project.controller;

import com.webminds.project.core.entidades.FacturaDTO;
import com.webminds.project.core.servicios.FacturaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/facturas")
public class FacturaController {

    private final FacturaServicio facturaServicio;

    public FacturaController(FacturaServicio facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    @GetMapping("/{userId}")
    public List<FacturaDTO> mostrarFacturasDeCliente(@PathVariable String userId){
        return facturaServicio.buscarFacturasPorCliente(userId);
    }

    @GetMapping("/{userId}/{facturaId}")
    public ResponseEntity<FacturaDTO> mostrarFacturaDelCliente(@PathVariable Integer facturaId, @PathVariable String userId){
        return facturaServicio
                .buscarFacturaPorCliente(facturaId,userId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FacturaDTO> crearFactura(@RequestBody FacturaDTO facturaDTO){
        return new ResponseEntity<>(facturaServicio.crearFactura(facturaDTO), HttpStatus.CREATED) ;
    }

    @PutMapping
    public ResponseEntity<FacturaDTO> actualizarFactura(@RequestBody FacturaDTO facturaDTO){
        return facturaServicio.actualizarFactura(facturaDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{facturaId}")
    public ResponseEntity<Boolean> eliminarFactura(@PathVariable Integer facturaId){
        boolean eliminado = facturaServicio.eliminarFactura(facturaId);
        if(eliminado){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
