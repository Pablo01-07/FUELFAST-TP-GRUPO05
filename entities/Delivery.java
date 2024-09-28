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
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDelivery;

    private String nombre;
    private String direccion;
    //private Date fechaEntrega;
    //private String horaEntrega;
    private LocalDate fechaEntrega;
    private LocalTime horaEntrega;
    private Double precio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private Estacion estacion;

    @JsonIgnore
    @OneToMany(mappedBy = "delivery")
    private List<SolicitudProducto> solicitudes;

}