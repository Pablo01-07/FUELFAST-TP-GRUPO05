package org.example.serviceimpl;

import org.example.dtos.DTOUsuario;
import org.example.entities.Authority;
import org.example.entities.Usuario;
import org.example.exceptions.ResourceNotFoundException;
import org.example.repositories.UsuarioRepository;
import org.example.security.SecurityUsuario;
import org.example.services.AuthorityService;
import org.example.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AuthorityService authorityService;

    @Override
    public Usuario findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new ResourceNotFoundException("Usuario con id: " + id + " no existe");
        }
        return usuario;
    }

    @Override
    public Usuario addUsuario(DTOUsuario dtoUsuario) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dtoUsuario.getUsername());
        usuario.setPassword(new BCryptPasswordEncoder().encode(dtoUsuario.getPassword()));
        usuario.setActivo(true);
        //usuario.setRegistrationDate(LocalDateTime.now());
        usuario.setAuthorities(authoritiesFromString(dtoUsuario.getAuthorities()));

        return usuarioRepository.save(usuario);
    }

    private List<Authority> authoritiesFromString(String authoritiesString) {
        List<Authority> authorityList = new ArrayList<>();
        List<String> authorityStringList = List.of(authoritiesString.split(";"));
        for (String authority : authorityStringList) {
            Authority foundAuthority = authorityService.findByName(authority);
            if (foundAuthority != null) {
                authorityList.add(foundAuthority);
            }
        }
        return authorityList;
    }

    @Override
    public Usuario findByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new ResourceNotFoundException("Usuario con username: " + username + " no existe");
        }
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new SecurityUsuario(this.findByUsername(username));
    }
}