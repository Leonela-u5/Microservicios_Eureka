package com.leonela.producto_service.repository;

import com.leonela.producto_service.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductoRepository {

    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // DATOS INICIALES
    public ProductoRepository() {

        productos.add(new Producto(
                idCounter.getAndIncrement(),
                "Laptop Gamer",
                3200.0,
                8));

        productos.add(new Producto(
                idCounter.getAndIncrement(),
                "Monitor Curvo",
                850.0,
                15));

        productos.add(new Producto(
                idCounter.getAndIncrement(),
                "Teclado Mecánico RGB",
                120.0,
                30));

        productos.add(new Producto(
                idCounter.getAndIncrement(),
                "Auriculares Bluetooth",
                95.0,
                20));

        productos.add(new Producto(
                idCounter.getAndIncrement(),
                "Mouse Inalámbrico",
                45.0,
                40));
    }

    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }

    public Optional<Producto> findById(Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst();
    }

    public Producto save(Producto producto) {

        if (producto.getId() == null) {

            producto.setId(idCounter.getAndIncrement());

            productos.add(producto);

        } else {

            findById(producto.getId()).ifPresent(existing -> {

                int index = productos.indexOf(existing);

                productos.set(index, producto);
            });
        }

        return producto;
    }

    public void deleteById(Long id) {

        productos.removeIf(producto -> producto.getId().equals(id));
    }
}