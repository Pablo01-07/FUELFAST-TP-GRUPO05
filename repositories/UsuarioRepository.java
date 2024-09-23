package org.example.repositories;

import org.example.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public List<Usuario> findByCliente_IdCliente(Long idCliente);

}