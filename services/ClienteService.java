package org.example.services;

import org.example.entities.Cliente;

import java.util.List;

public interface ClienteService {

    public Cliente addCliente(Cliente cliente);
    public List<Cliente> listAll();
    public Cliente findById(Long id);
    public Cliente updateCliente(Long id, Cliente cliente);
    public void deleteCliente(Long id);
    public List<Cliente> findByDni(String dni);

}