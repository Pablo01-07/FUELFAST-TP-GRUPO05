package org.example.repositories;

import org.example.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM delivery ORDER BY fechaEntrega ASC")
    public List<Delivery> listaOrdFechaEntregaAsc();

    public List<Delivery> findByEstacion_IdEstacion(Long idEstacion);

    public List<Delivery> findByDireccionContaining(String direccion);

}