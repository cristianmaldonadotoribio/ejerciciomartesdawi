package com.example.ejerciciomartes.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

     @PostMapping("/registrar")
    public ResponseEntity<?> registrarCliente(@RequestBody Producto producto) {
               HashMap<String, Object> salida = new HashMap<>();
        try {
            Producto objSalida = productoService.insertaActualizaProducto(producto);
            objSalida.setIdProducto(0);
            salida.put("mensaje", "Cliente registrado de ID >>> " + objSalida.getIdProducto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizaCliente(@RequestBody Producto producto) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Producto objSalida = productoService.insertaActualizaProducto(producto);
            salida.put("mensaje", "Cliente actualizado de ID >>> " + objSalida.getIdProducto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al actualizar");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminaProducto(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            productoService.eliminaProducto(id);
            salida.put("mensaje", "Producto eliminado de ID >>> " + id);
        } catch (Exception e) {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Producto producto = productoService.obtienePorId(id).get();
            salida.put("producto", producto);
        } catch (Exception e) {
            salida.put("mensaje", "Error al buscar");
        }
        return ResponseEntity.ok(salida);
    }
}
