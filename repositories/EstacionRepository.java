package org.example.repositories;

import org.example.entities.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM estacion ORDER BY nombreEstacion ASC")
    public List<Estacion> listaOrdNombreEstacionAsc();

    public List<Estacion> findByUbigeo_IdUbigeo(Long idUbigeo);

    public List<Estacion> findByProveedor_IdProveedor(Long idProveedor);

}