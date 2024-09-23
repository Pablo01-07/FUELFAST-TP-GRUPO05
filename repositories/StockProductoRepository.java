package org.example.repositories;

import org.example.entities.StockProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockProductoRepository extends JpaRepository<StockProducto, Integer> {

    public List<StockProducto> findByEstacion_IdEstacion(Long idEstacion);

    public List<StockProducto> findByProducto_IdProducto(Long idProducto);

    public List<StockProducto> findByStockGreaterThan(Integer stock);

}