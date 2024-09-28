package org.example.serviceimpl;

import org.example.entities.Authority;
import org.example.exceptions.ResourceNotFoundException;
import org.example.repositories.AuthorityRepository;
import org.example.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public Authority findById(Long id) {
        /*
        User userFound= userRepository.findById(id).orElse(null);
        if (userFound==null){
            throw new ResourceNotFoundException("User with id: " +  id + " does not exist");
        }
        return userFound;
         */
        Authority authorityFound = authorityRepository.findById(id).orElse(null);
        if (authorityFound==null) {
            throw new ResourceNotFoundException("Authority with id: " +  id + " does not exist");
        }
        return null;
    }

    @Override
    public Authority addAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public Authority findByName(String name) {
        Authority authorityFound = authorityRepository.findByName(name);
        if (authorityFound==null) {
            throw new ResourceNotFoundException("Authority with name: " +  name + " does not exist");
        }
        return authorityFound;
    }
}
