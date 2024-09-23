package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOEstacion {

    private Long idEstacion;
    private String nombre;
    private String ubicacion;
    private String telefono;
    private Long ciudad_id;
    private Long proveedor_id;

}