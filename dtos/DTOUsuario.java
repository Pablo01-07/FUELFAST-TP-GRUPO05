package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOUsuario {

    private Long idUsuario;
    private String username;
    private String password;
    private String authorities;

}
