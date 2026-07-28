package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Cliente;
import com.example.entities.Puesto;
import com.example.exepcion.BadRequestException;
import com.example.exepcion.ResourceNotFoundException;
import com.example.repository.ClienteRepository;
import com.example.repository.PuestoRepository;

@Service
public class PuestoService {

    @Autowired 
    private PuestoRepository puestoRepository;

    public List<Puesto> getAllPuestos() {
        return puestoRepository.findAll();
    }

    public Puesto getPuestoById(Long id) {
        return puestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Puesto no encontrado: " + id));
    }

    @Autowired
    private ClienteRepository clienteRepository;
public Puesto crearPuesto(Puesto puesto) {

    if (puesto.getNombre() == null || puesto.getNombre().isBlank()) {
        throw new BadRequestException("El nombre del puesto es obligatorio");
    }

    if (puesto.getCliente() == null || puesto.getCliente().getId() == null) {
        throw new BadRequestException("El cliente es obligatorio");
    }


    Cliente cliente = clienteRepository.findById(puesto.getCliente().getId())
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Cliente no encontrado: " + puesto.getCliente().getId()
                    )
            );


    puesto.setCliente(cliente);

    return puestoRepository.save(puesto);
}

    public Puesto actualizarPuesto(Long id, Puesto puesto) {
        Puesto puestoExistente = puestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Puesto no encontrado: " + id));

        puestoExistente.setNombre(puesto.getNombre());
        puestoExistente.setCliente(puesto.getCliente());
        puestoExistente.setDireccion(puesto.getDireccion());
        puestoExistente.setActivo(true);

        return puestoRepository.save(puestoExistente);
    }

    public void eliminarPuesto(Long id) {
        Puesto puestoExistente = puestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Puesto no encontrado: " + id));
        puestoRepository.delete(puestoExistente);
    }

    
}
