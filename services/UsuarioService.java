package org.example.services;

import org.example.dtos.DTOUsuario;
import org.example.entities.Usuario;

public interface UsuarioService {

    public Usuario findById(Long id);
    public Usuario addUsuario(DTOUsuario dtoUsuario);
    public Usuario findByUsername(String userName);

}