package org.example.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private Authority authority; // Adaptado a tu entidad Authority

    @Override
    public String getAuthority() {
        return authority.getName(); // Ajustado para tu diagrama
    }
}
