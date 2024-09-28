package org.example.controllers;

import org.example.dtos.DTOToken;
import org.example.dtos.DTOUsuario;
import org.example.entities.Usuario;
import org.example.security.JwtUtilService;
import org.example.security.SecurityUsuario;
import org.example.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtilService jwtUtilService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuarios/register")
    public ResponseEntity<Usuario> insertUsuario(@RequestBody DTOUsuario dtoUsuario){
        Usuario newUsuario = usuarioService.addUsuario(dtoUsuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Usuario usuarioFound = usuarioService.findById(id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }

    @PostMapping("/usuarios/login")
    public ResponseEntity<DTOToken> login(@RequestBody DTOUsuario dtoUsuario) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoUsuario.getUsername(), dtoUsuario.getPassword()));
        SecurityUsuario securityUsuario = new SecurityUsuario(usuarioService.findByUsername(dtoUsuario.getUsername()));
        String jwt = jwtUtilService.generateToken(securityUsuario);
        Long usuarioId = securityUsuario.getUsuario().getIdUsuario();

        String authString = securityUsuario.getUsuario().getAuthorities().stream().map(a -> a.getName()).collect(Collectors.joining(";"));

        return new ResponseEntity<>(new DTOToken(jwt, usuarioId, authString), HttpStatus.OK);
    }
}
