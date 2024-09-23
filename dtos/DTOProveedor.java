package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOProveedor {

    private Long idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;

}