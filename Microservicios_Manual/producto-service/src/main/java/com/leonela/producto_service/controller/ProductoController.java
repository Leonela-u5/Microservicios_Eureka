package com.leonela.producto_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonela.producto_service.model.Producto;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/productos")

public class ProductoController {
     List<Producto> lista = new ArrayList<>();

    public ProductoController() {

        lista.add(new Producto(1L, "Laptop", 2500.0));
        lista.add(new Producto(2L, "Mouse", 25.0));
    }

    // Endpoint GET
    @GetMapping
    public List<Producto> listar() {
        return lista;
    }

    // Endpoint GET BY ID
    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {

        return lista.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Endpoint POST
    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {

        lista.add(producto);

        return producto;
    }
}
