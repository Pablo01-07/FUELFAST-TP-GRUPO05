package org.example.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.entities.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class SecurityUsuario implements UserDetails {

    private Usuario usuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getAuthorities().stream()
                .map(SecurityAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usuario.getPassword(); // Ajustado según tu campo
    }

    @Override
    public String getUsername() {
        return usuario.getUsername(); // Ajustado según tu campo
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() { return usuario.getActivo(); }
    //public boolean isEnabled() { return usuario.isEnabled(); }
}