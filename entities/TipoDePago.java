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
@Table(name = "tipo_pago")
public class TipoDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPago;

    private Boolean pagoContraEntrega;
    private Boolean pagoTarjeta;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoDePago")
    private List<SolicitudProducto> solicitudes;

}