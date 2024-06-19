package com.example.ejerciciomartes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ejerciciomartes.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
