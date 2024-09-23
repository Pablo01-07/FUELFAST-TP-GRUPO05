package org.example.services;

import org.example.entities.SolicitudProducto;

import java.util.List;

public interface SolicitudProductoService {

    public SolicitudProducto addSolicitudProducto(SolicitudProducto solicitudProducto);
    public List<SolicitudProducto> listAll();
    public SolicitudProducto findById(Long id);
    public SolicitudProducto updateSolicitudProducto(Long id, SolicitudProducto solicitudProducto);
    public void deleteSolicitudProducto(Long id);

}