package org.example.serviceimpl;

import org.example.entities.Cliente;
import org.example.exceptions.ResourceNotFoundException;
import org.example.repositories.ClienteRepository;
import org.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ResourceNotFoundException("Cliente not found with id: " + id);
        }
        return cliente;
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente existingCliente = findById(id);
        existingCliente.setNombreCompleto(cliente.getNombreCompleto());
        existingCliente.setDni(cliente.getDni());
        existingCliente.setDireccion(cliente.getDireccion());
        return clienteRepository.save(existingCliente);
    }

    @Override
    public void deleteCliente(Long id) {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }

    @Override
    public List<Cliente> findByDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

}