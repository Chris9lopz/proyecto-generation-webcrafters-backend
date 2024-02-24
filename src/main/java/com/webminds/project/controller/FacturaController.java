package com.webminds.project.controller;

import com.webminds.project.core.entidades.FacturaDTO;
import com.webminds.project.core.entidades.comandos.FacturaPeticionDTO;
import com.webminds.project.core.entidades.consultas.FacturaConsultaDTO;
import com.webminds.project.core.entidades.consultas.ProductoEnFacturaConsultaDTO;
import com.webminds.project.core.excepciones.ModoPagoNoExisteException;
import com.webminds.project.core.excepciones.ProductoNoExisteException;
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
    public ResponseEntity<FacturaConsultaDTO> mostrarFacturaDelCliente(@PathVariable Integer facturaId, @PathVariable String userId){
        return facturaServicio
                .buscarFacturaPorCliente(facturaId,userId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?>  crearFactura(@RequestBody FacturaPeticionDTO facturaPeticionDTO)  {
        try {
            return new ResponseEntity<>(facturaServicio.crearFactura(facturaPeticionDTO), HttpStatus.CREATED) ;
        } catch (ModoPagoNoExisteException | ProductoNoExisteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
