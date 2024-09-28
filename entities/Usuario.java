package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String username;
    private String password;
    private Boolean activo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_authorities",
            joinColumns = @JoinColumn(
                    name = "usuario_id",
                    referencedColumnName = "idUsuario",
                    nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "authority_id",
                    referencedColumnName = "idAuthority",
                    nullable = false)
    )
    private List<Authority> authorities;
}