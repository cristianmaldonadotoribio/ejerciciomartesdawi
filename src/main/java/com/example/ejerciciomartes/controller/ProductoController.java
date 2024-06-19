package com.example.ejerciciomartes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejerciciomartes.model.Producto;
import com.example.ejerciciomartes.service.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/url/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listarTodos")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }
}
