package org.example.repositories;

import org.example.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM proveedor ORDER BY nombreProve ASC")
    public List<Proveedor> listaOrdNombreProveAsc();

    public List<Proveedor> findByDireccionContaining(String direccion);

    public List<Proveedor> findByEmail(String email);

}