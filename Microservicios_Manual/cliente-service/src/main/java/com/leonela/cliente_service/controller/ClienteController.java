package com.leonela.cliente_service.controller;

import com.leonela.cliente_service.model.Cliente;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    List<Cliente> lista = new ArrayList<>();

    public ClienteController() {

        lista.add(new Cliente(1L, "Ana", "ana@gmail.com"));
        lista.add(new Cliente(2L, "Luis", "luis@gmail.com"));
    }

    @GetMapping
    public List<Cliente> listar() {
        return lista;
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {

        return lista.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {

        lista.add(cliente);

        return cliente;
    }
}