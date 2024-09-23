package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoDetalle;

    private Integer cantidad;
    private Double precio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "solicitud_id")
    private SolicitudProducto solicitudProducto;

    @ManyToOne
    @JoinColumn(name = "stock_producto_id")
    private StockProducto stockProducto;

}