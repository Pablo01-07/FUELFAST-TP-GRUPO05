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
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String codigo;
    private String email;
    private String nombreCompleto;
    private String telefono;
    private String dni;
    private String direccion;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<SolicitudProducto> solicitudes;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Usuario> usuarios;

}