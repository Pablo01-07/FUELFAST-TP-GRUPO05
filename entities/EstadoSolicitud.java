package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estado_solicitud")
public class EstadoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoSolicitud;

    private String tipoEstadoSolicitud;

    @JsonIgnore
    @OneToMany(mappedBy = "estadoSolicitud")
    private List<SolicitudProducto> solicitudes;

}