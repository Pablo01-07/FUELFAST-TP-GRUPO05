package org.example.repositories;

import org.example.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM cliente ORDER BY nombreCompleto ASC")
    public List<Cliente> listaOrdNombreCompletoAsc();

    @Query(value = "SELECT c FROM Cliente c ORDER BY c.codigo DESC")
    public List<Cliente> listaOrdCodigoDesc();

    public List<Cliente> findByDni(String dni);

    public List<Cliente> findByDireccion(String direccion);

}