package com.example.ejerciciomartes.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ejerciciomartes.model.Producto;
import com.example.ejerciciomartes.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    @Override
    public Producto insertaActualizaProducto(Producto obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaProducto(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Producto> obtienePorId(int id) {
        return repository.findById(id);
    }
    
}
