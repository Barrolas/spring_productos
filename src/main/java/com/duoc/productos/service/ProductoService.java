package com.duoc.productos.service;

import com.duoc.productos.model.Producto;
import com.duoc.productos.repository.ProductoRepository;
import com.duoc.productos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Crear o actualizar producto
    public Producto save(Producto producto) {
        if (producto.getCategoria() != null && producto.getCategoria().getCategoriaId() != null) {
            categoriaRepository.findById(producto.getCategoria().getCategoriaId())
                .ifPresent(producto::setCategoria);
        }
        return productoRepository.save(producto);
    }

    // Buscar producto por ID
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    // Listar todos los productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    // Eliminar producto por ID
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    // Verificar si existe producto por ID
    public boolean existsById(Long id) {
        return productoRepository.existsById(id);
    }
}
