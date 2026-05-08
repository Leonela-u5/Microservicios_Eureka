package com.leonela.producto_service.service;

import com.leonela.producto_service.dto.ProductoDTO;
import com.leonela.producto_service.exception.ResourceNotFoundException;
import com.leonela.producto_service.model.Producto;
import com.leonela.producto_service.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> findAll(int page, int size) {
        List<Producto> allProductos = productoRepository.findAll();
        
        int start = Math.min(page * size, allProductos.size());
        int end = Math.min((page + 1) * size, allProductos.size());
        
        return allProductos.subList(start, end).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProductoDTO findById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el id: " + id));
        return mapToDTO(producto);
    }

    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = mapToEntity(productoDTO);
        producto.setId(null); // Ensure a new ID is generated
        Producto saved = productoRepository.save(producto);
        return mapToDTO(saved);
    }

    public ProductoDTO update(Long id, ProductoDTO productoDTO) {
        Producto existing = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el id: " + id));
        
        existing.setNombre(productoDTO.getNombre());
        existing.setPrecio(productoDTO.getPrecio());
        existing.setStock(productoDTO.getStock());
        
        Producto updated = productoRepository.save(existing);
        return mapToDTO(updated);
    }

    public ProductoDTO patch(Long id, ProductoDTO productoDTO) {
        Producto existing = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el id: " + id));
        
        if (productoDTO.getNombre() != null) existing.setNombre(productoDTO.getNombre());
        if (productoDTO.getPrecio() != null) existing.setPrecio(productoDTO.getPrecio());
        if (productoDTO.getStock() != null) existing.setStock(productoDTO.getStock());
        
        Producto updated = productoRepository.save(existing);
        return mapToDTO(updated);
    }

    public void delete(Long id) {
        Producto existing = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el id: " + id));
        productoRepository.deleteById(existing.getId());
    }

    private ProductoDTO mapToDTO(Producto producto) {
        return new ProductoDTO(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock());
    }

    private Producto mapToEntity(ProductoDTO dto) {
        return new Producto(dto.getId(), dto.getNombre(), dto.getPrecio(), dto.getStock());
    }
}
