package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTOToken {
    //private String jwtToken;
    private String token;
    private Long usuarioId;
    private String authorities;
}