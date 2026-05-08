package com.leonela.cliente_service.repository;

import com.leonela.cliente_service.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    public Optional<Cliente> findById(Long id) {
        return clientes.stream()
            .filter(cliente -> cliente.getId().equals(id))
            .findFirst();
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(idCounter.getAndIncrement());
            clientes.add(cliente);
        } else {
            findById(cliente.getId()).ifPresent(existing -> {
                int index = clientes.indexOf(existing);
                clientes.set(index, cliente);
            });
        }
        return cliente;
    }

    public void deleteById(Long id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}
