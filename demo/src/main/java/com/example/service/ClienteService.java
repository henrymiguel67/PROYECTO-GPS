package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Cliente;
import com.example.exepcion.BadRequestException;
import com.example.exepcion.ResourceNotFoundException;
import com.example.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> getALLCLientes() {
        return clienteRepository.findAll();
    }


    public Cliente getClienteById(Long id) {

        return clienteRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Cliente no encontrado: " + id)
                );
    }


    public Cliente crearCliente(Cliente cliente) {

        if (cliente.getNombreEmpresa() == null || cliente.getNombreEmpresa().isBlank()) {
            throw new BadRequestException("El nombre de la empresa es obligatorio");
        }

        if (cliente.getNit() == null || cliente.getNit().isBlank()) {
            throw new BadRequestException("El NIT es obligatorio");
        }

        if (cliente.getCorreo() == null || cliente.getCorreo().isBlank()) {
            throw new BadRequestException("El correo es obligatorio");
        }


        return clienteRepository.save(cliente);
    }


    public Cliente actualizarCliente(Long id, Cliente cliente) {

        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Cliente no encontrado: " + id)
                );


        if (cliente.getNombreEmpresa() == null || cliente.getNombreEmpresa().isBlank()) {
            throw new BadRequestException("El nombre de la empresa es obligatorio");
        }

        if (cliente.getNit() == null || cliente.getNit().isBlank()) {
            throw new BadRequestException("El NIT es obligatorio");
        }

        if (cliente.getCorreo() == null || cliente.getCorreo().isBlank()) {
            throw new BadRequestException("El correo es obligatorio");
        }


        clienteExistente.setNombreEmpresa(cliente.getNombreEmpresa());
        clienteExistente.setNit(cliente.getNit());
        clienteExistente.setRepresentante(cliente.getRepresentante());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setCorreo(cliente.getCorreo());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setActivo(cliente.isActivo());


        return clienteRepository.save(clienteExistente);
    }


    public void eliminarCliente(Long id) {

        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Cliente no encontrado: " + id)
                );


        clienteRepository.delete(clienteExistente);
    }

}