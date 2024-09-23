package org.example.repositories;

import org.example.entities.SolicitudProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolicitudProductoRepository extends JpaRepository<SolicitudProducto, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM solicitud_producto ORDER BY fechaSolicitud DESC")
    List<SolicitudProducto> listaOrdFechaSolicitudDesc();

    public List<SolicitudProducto> findByCliente_IdCliente(Long idCliente);

    public List<SolicitudProducto> findByEstadoSolicitud_IdEstadoSolicitud(Long idEstadoSolicitud);

    public List<SolicitudProducto> findByMetodoPago(String metodoPago);

}