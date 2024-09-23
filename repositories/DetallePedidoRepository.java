package org.example.repositories;

import org.example.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    //@Query(nativeQuery = true, value = "SELECT * FROM detalle_pedido WHERE solicitud_combustible_id_solicitud = ?1")
    @Query(nativeQuery = true, value = "SELECT * FROM detalle_pedido WHERE solicitud_producto_id_solicitud = ?1")
    public List<DetallePedido> findBySolicitudProductoId(Long idSolicitudProducto);

}