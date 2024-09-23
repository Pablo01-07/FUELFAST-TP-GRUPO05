package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOProducto {

    private Long idProducto;
    private String nombre;
    private Double precio;
    private Long estacion_id;

}