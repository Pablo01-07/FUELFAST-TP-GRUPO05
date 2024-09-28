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
@Table(name = "estaciones")
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstacion;

    private String nombreEstacion;
    private String direccion;
    private String telefono;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ubigeo_id")
    private Ubigeo ubigeo;

    @JsonIgnore
    @OneToMany(mappedBy = "estacion")
    private List<StockProducto> stockProductos;

    @JsonIgnore
    @OneToMany(mappedBy = "estacion")
    private List<Delivery> deliveries;

}