package org.example.repositories;

import org.example.entities.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UbigeoRepository extends JpaRepository<Ubigeo, Long> {

    public List<Ubigeo> findByCiudad(String ciudad);

    public List<Ubigeo> findByDistrito(String distrito);

}