package org.example.services;

import org.example.entities.Producto;

import java.util.List;

public interface ProductoService {

    public Producto addProducto(Producto producto);
    public List<Producto> listAll();
    public Producto findById(Long id);
    public Producto updateProducto(Long id, Producto producto);
    public void deleteProducto(Long id);
    public List<Producto> listByTipoProductoId(Long idTipoProducto);

}