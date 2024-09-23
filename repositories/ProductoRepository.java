package org.example.repositories;

import org.example.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public List<Producto> findByTipoProducto_IdTipoProducto(Long idTipoProducto);

}