package org.example.serviceimpl;

import org.example.entities.Cliente;
import org.example.entities.Estacion;
import org.example.exceptions.ResourceNotFoundException;
import org.example.repositories.EstacionRepository;
import org.example.services.EstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionServiceImpl implements EstacionService {

    @Autowired
    EstacionRepository estacionRepository;

    @Override
    public Estacion addEstacion(Estacion estacion) {
        return estacionRepository.save(estacion);
    }

    @Override
    public List<Estacion> listAll() {
        return estacionRepository.findAll();
    }

    @Override
    public Estacion findById(Long id) {
        Estacion estacion = estacionRepository.findById(id).orElse(null);
        if (estacion == null) {
            throw new ResourceNotFoundException("Estacion not found with id: " + id);
        }
        return estacion;
    }

    @Override
    public Estacion updateEstacion(Long id, Estacion estacion) {
        Estacion existingEstacion = findById(id);
        existingEstacion.setNombreEstacion(estacion.getNombreEstacion());
        existingEstacion.setUbigeo(estacion.getUbigeo());
        return estacionRepository.save(existingEstacion);
    }

    @Override
    public void deleteEstacion(Long id) {
        Estacion estacion = findById(id);
        estacionRepository.delete(estacion);
    }

    @Override
    public List<Estacion> listByUbigeoId(Long idUbigeo) {
        return estacionRepository.findByUbigeo_IdUbigeo(idUbigeo);
    }

}