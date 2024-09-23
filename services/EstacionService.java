package org.example.services;

import org.example.entities.Estacion;

import java.util.List;

public interface EstacionService {

    public Estacion addEstacion(Estacion estacion);
    public List<Estacion> listAll();
    public Estacion findById(Long id);
    public Estacion updateEstacion(Long id, Estacion estacion);
    public void deleteEstacion(Long id);
    public List<Estacion> listByUbigeoId(Long idUbigeo);

}