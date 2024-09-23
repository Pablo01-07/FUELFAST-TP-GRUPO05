package org.example.serviceimpl;

import org.example.entities.Cliente;
import org.example.entities.SolicitudProducto;
import org.example.exceptions.ResourceNotFoundException;
import org.example.repositories.SolicitudProductoRepository;
import org.example.services.SolicitudProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudProductoServiceImpl implements SolicitudProductoService {

    @Autowired
    SolicitudProductoRepository solicitudProductoRepository;

    @Override
    public SolicitudProducto addSolicitudProducto(SolicitudProducto solicitudProducto) {
        return solicitudProductoRepository.save(solicitudProducto);
    }

    @Override
    public List<SolicitudProducto> listAll() {
        return solicitudProductoRepository.findAll();
    }

    @Override
    public SolicitudProducto findById(Long id) {
        SolicitudProducto solicitudProducto = solicitudProductoRepository.findById(id).orElse(null);
        if (solicitudProducto == null) {
            throw new ResourceNotFoundException("Solicitud Producto not found with id: " + id);
        }
        return solicitudProducto;
    }

    @Override
    public SolicitudProducto updateSolicitudProducto(Long id, SolicitudProducto solicitudProducto) {
        SolicitudProducto existingSolicitud = findById(id);
        existingSolicitud.setFechaSolicitud(solicitudProducto.getFechaSolicitud());
        existingSolicitud.setMetodoPago(solicitudProducto.getMetodoPago());
        existingSolicitud.setEstadoSolicitud(solicitudProducto.getEstadoSolicitud());
        return solicitudProductoRepository.save(existingSolicitud);
    }

    @Override
    public void deleteSolicitudProducto(Long id) {
        SolicitudProducto solicitudProducto = findById(id);
        solicitudProductoRepository.delete(solicitudProducto);
    }
}