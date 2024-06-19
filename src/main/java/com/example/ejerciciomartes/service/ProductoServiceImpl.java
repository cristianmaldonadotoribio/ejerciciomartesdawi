package com.example.ejerciciomartes.service;
import java.util.List;

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
    
}
