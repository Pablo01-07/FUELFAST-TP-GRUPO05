package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOCliente {

    private Long idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}