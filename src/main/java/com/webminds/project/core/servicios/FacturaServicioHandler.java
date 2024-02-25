package com.webminds.project.core.servicios;

import com.webminds.project.core.entidades.FacturaDTO;
import com.webminds.project.core.entidades.comandos.FacturaPeticionDTO;
import com.webminds.project.core.entidades.comandos.ProductoEnFacturaPeticionDTO;
import com.webminds.project.core.entidades.consultas.FacturaConsultaDTO;
import com.webminds.project.core.excepciones.ModoPagoNoExisteException;
import com.webminds.project.core.excepciones.ProductoNoExisteException;
import com.webminds.project.infraestructura.entidades.FacturaDAO;
import com.webminds.project.infraestructura.entidades.ModoPagoDAO;
import com.webminds.project.infraestructura.entidades.ProductoDAO;
import com.webminds.project.infraestructura.entidades.ProductoFacturaDAO;
import com.webminds.project.infraestructura.mappers.FacturaMapper;
import com.webminds.project.infraestructura.mappers.ModoPagoMapper;
import com.webminds.project.infraestructura.mappers.ProductoMapper;
import com.webminds.project.infraestructura.repository.FacturaRepository;
import com.webminds.project.infraestructura.repository.ProductoEnFacturaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacturaServicioHandler implements FacturaServicio {

    private final FacturaRepository facturaRepository;
    private final ModoPagoServicio modoPagoServicio;
    private final ProductoServicio productoServicio;

    private final ProductoEnFacturaRepositorio productoEnFacturaRepositorio;

    public FacturaServicioHandler(FacturaRepository facturaRepository, ModoPagoServicio modoPagoServicio, ProductoServicio productoServicio, ProductoEnFacturaRepositorio productoEnFacturaRepositorio) {
        this.facturaRepository = facturaRepository;
        this.modoPagoServicio = modoPagoServicio;
        this.productoServicio = productoServicio;
        this.productoEnFacturaRepositorio = productoEnFacturaRepositorio;
    }

    @Override
    public List<FacturaConsultaDTO> buscarFacturasPorCliente(String userId) {
        return facturaRepository
                .buscarFacturasPorCliente(userId)
                .stream()
                .map(FacturaMapper::pasarAConsultaDTO)
                .toList();
    }

    @Override
    public Optional<FacturaConsultaDTO> buscarFacturaPorCliente(Integer facturaId, String userId) {
        return facturaRepository.buscarFacturaPorCliente(facturaId, userId).map(FacturaMapper::pasarAConsultaDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public FacturaConsultaDTO crearFactura(FacturaPeticionDTO facturaPeticionDTO) throws ModoPagoNoExisteException,ProductoNoExisteException {
        FacturaDAO facturaDAO = new FacturaDAO();
        facturaDAO.setFecha(LocalDate.now());
        facturaDAO.setUsuarioId(facturaPeticionDTO.getUsuarioId());
        facturaDAO.setModoPagoDAO(consultarModoDePago(facturaPeticionDTO));
        FacturaDAO facturaAlmacenada = facturaRepository.save(facturaDAO);
        List<ProductoFacturaDAO> productosEnFactura = obtenerProductos(facturaPeticionDTO, facturaAlmacenada);
        facturaAlmacenada.setProductosEnFactura(productosEnFactura);
        productoEnFacturaRepositorio.saveAll(productosEnFactura);
        return FacturaMapper.pasarAConsultaDTO(facturaAlmacenada);
    }

    @Transactional(rollbackFor = Exception.class)
    private List<ProductoFacturaDAO> obtenerProductos(FacturaPeticionDTO facturaPeticionDTO, FacturaDAO factura) throws ProductoNoExisteException {
        List<ProductoFacturaDAO> listadoDeProductos = new ArrayList<>();
        for (ProductoEnFacturaPeticionDTO productoEnFactura : facturaPeticionDTO.getProductosEnFactura()) {
            ProductoDAO productoDAO = productoServicio
                    .buscarProductoPorId(productoEnFactura.getProductoId())
                    .map(ProductoMapper::pasarAProductoDAO)
                    .orElseThrow(()->new ProductoNoExisteException(productoEnFactura.getProductoId()));
            listadoDeProductos.add(new ProductoFacturaDAO(factura,productoDAO, productoEnFactura.getCantidad()));
        }
        return listadoDeProductos;
    }

    @Transactional(rollbackFor = Exception.class)
    private ModoPagoDAO consultarModoDePago(FacturaPeticionDTO facturaDTO) throws ModoPagoNoExisteException {
        return modoPagoServicio
                .buscarModoPagoPorId(facturaDTO.getModoPago())
                .map(ModoPagoMapper::pasarAModoPagoDAO)
                .orElseThrow(() -> new ModoPagoNoExisteException(facturaDTO.getModoPago()));
    }

    @Override
    public Optional<FacturaDTO> actualizarFactura(FacturaDTO facturaDTO) {
        return facturaRepository
                .buscarFacturaPorCliente(facturaDTO.getFacturaID(), facturaDTO.getUsuarioID())
                .map(facturaDAO -> FacturaMapper.pasarADTO(facturaRepository.save(FacturaMapper.pasarADAO(facturaDTO))));
    }

    @Override
    public Boolean eliminarFactura(Integer facturaId) {
        return facturaRepository.buscarFacturaPorIdDeFactura(facturaId)
                .map(facturaDAO -> {
                    facturaRepository.deleteById(facturaId);
                    return true;
                }
        ).orElse(false);
    }
}
