package org.example.services;

import org.example.entities.Authority;

public interface AuthorityService {

    public Authority findById(Long id);
    public Authority addAuthority(Authority authority);
    public Authority findByName(String name);

}
