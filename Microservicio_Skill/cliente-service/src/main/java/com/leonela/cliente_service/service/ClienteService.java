package com.leonela.cliente_service.service;

import com.leonela.cliente_service.dto.ClienteDTO;
import com.leonela.cliente_service.exception.ResourceNotFoundException;
import com.leonela.cliente_service.model.Cliente;
import com.leonela.cliente_service.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> findAll(int page, int size) {
        List<Cliente> allClientes = clienteRepository.findAll();
        
        int start = Math.min(page * size, allClientes.size());
        int end = Math.min((page + 1) * size, allClientes.size());
        
        return allClientes.subList(start, end).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con el id: " + id));
        return mapToDTO(cliente);
    }

    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = mapToEntity(clienteDTO);
        cliente.setId(null); // Ensure a new ID is generated
        Cliente saved = clienteRepository.save(cliente);
        return mapToDTO(saved);
    }

    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        Cliente existing = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con el id: " + id));
        
        existing.setNombre(clienteDTO.getNombre());
        existing.setCorreo(clienteDTO.getCorreo());
        existing.setTelefono(clienteDTO.getTelefono());
        
        Cliente updated = clienteRepository.save(existing);
        return mapToDTO(updated);
    }

    public ClienteDTO patch(Long id, ClienteDTO clienteDTO) {
        Cliente existing = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con el id: " + id));
        
        if (clienteDTO.getNombre() != null) existing.setNombre(clienteDTO.getNombre());
        if (clienteDTO.getCorreo() != null) existing.setCorreo(clienteDTO.getCorreo());
        if (clienteDTO.getTelefono() != null) existing.setTelefono(clienteDTO.getTelefono());
        
        Cliente updated = clienteRepository.save(existing);
        return mapToDTO(updated);
    }

    public void delete(Long id) {
        Cliente existing = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con el id: " + id));
        clienteRepository.deleteById(existing.getId());
    }

    private ClienteDTO mapToDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getCorreo(), cliente.getTelefono());
    }

    private Cliente mapToEntity(ClienteDTO dto) {
        return new Cliente(dto.getId(), dto.getNombre(), dto.getCorreo(), dto.getTelefono());
    }
}
