package org.example.serviceimpl;

import org.example.entities.Cliente;
import org.example.entities.Producto;
import org.example.exceptions.ResourceNotFoundException;
import org.example.repositories.ProductoRepository;
import org.example.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto == null) {
            throw new ResourceNotFoundException("Producto not found with id: " + id);
        }
        return producto;
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        Producto existingProducto = findById(id);
        //existingProducto.setNombreProducto(producto.getNombreProducto());
        existingProducto.setTipoProducto(producto.getTipoProducto());
        return productoRepository.save(existingProducto);
    }

    @Override
    public void deleteProducto(Long id) {
        Producto producto = findById(id);
        productoRepository.delete(producto);
    }

    @Override
    public List<Producto> listByTipoProductoId(Long idTipoProducto) {
        return productoRepository.findByTipoProducto_IdTipoProducto(idTipoProducto);
    }

}