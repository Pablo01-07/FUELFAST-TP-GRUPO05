package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solicitud_producto")
public class SolicitudProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;

    //private Date fechaSolicitud;
    //private String horaSolicitud;
    private LocalDate fechaSolicitud;
    private LocalTime horaSolicitud;
    private Double montoTotal;
    private String metodoPago;
    //private Date fechaPago;
    private LocalDate fechaPago;
    private Integer numGalones;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "estado_solicitud_id")
    private EstadoSolicitud estadoSolicitud;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tipo_pago_id")
    private TipoDePago tipoDePago;

    @JsonIgnore
    @OneToMany(mappedBy = "solicitudProducto")
    private List<DetallePedido> detallesPedido;

}