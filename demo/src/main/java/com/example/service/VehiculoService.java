package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Vehiculo;
import com.example.exepcion.BadRequestException;
import com.example.exepcion.ResourceNotFoundException;
import com.example.repository.VehiculoRepository;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;


    public List<Vehiculo> getALLVehiculos() {
        return vehiculoRepository.findAll();
    }


    public Vehiculo getVehiculoById(Long id) {

        return vehiculoRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Vehículo no encontrado: " + id)
                );
    }


    public Vehiculo crearVehiculo(Vehiculo vehiculo) {

        if (vehiculo.getPropietario() == null || vehiculo.getPropietario().isBlank()) {
            throw new BadRequestException("El propietario es obligatorio");
        }

        if (vehiculo.getPlaca() == null || vehiculo.getPlaca().isBlank()) {
            throw new BadRequestException("La placa es obligatoria");
        }

        if (vehiculo.getMarca() == null || vehiculo.getMarca().isBlank()) {
            throw new BadRequestException("La marca es obligatoria");
        }

        if (vehiculo.getModelo() == null || vehiculo.getModelo().isBlank()) {
            throw new BadRequestException("El modelo es obligatorio");
        }

        if (vehiculo.getColor() == null || vehiculo.getColor().isBlank()) {
            throw new BadRequestException("El color es obligatorio");
        }

        if (vehiculo.getTipo() == null) {
            throw new BadRequestException("El tipo de vehículo es obligatorio");
        }

        return vehiculoRepository.save(vehiculo);
    }


    public Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculo) {

        Vehiculo vehiculoExistente = vehiculoRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Vehículo no encontrado: " + id)
                );


        if (vehiculo.getPropietario() == null || vehiculo.getPropietario().isBlank()) {
            throw new BadRequestException("El propietario es obligatorio");
        }

        if (vehiculo.getPlaca() == null || vehiculo.getPlaca().isBlank()) {
            throw new BadRequestException("La placa es obligatoria");
        }

        if (vehiculo.getMarca() == null || vehiculo.getMarca().isBlank()) {
            throw new BadRequestException("La marca es obligatoria");
        }

        if (vehiculo.getModelo() == null || vehiculo.getModelo().isBlank()) {
            throw new BadRequestException("El modelo es obligatorio");
        }

        if (vehiculo.getColor() == null || vehiculo.getColor().isBlank()) {
            throw new BadRequestException("El color es obligatorio");
        }

        if (vehiculo.getTipo() == null) {
            throw new BadRequestException("El tipo de vehículo es obligatorio");
        }


        vehiculoExistente.setPropietario(vehiculo.getPropietario());
        vehiculoExistente.setPlaca(vehiculo.getPlaca());
        vehiculoExistente.setMarca(vehiculo.getMarca());
        vehiculoExistente.setColor(vehiculo.getColor());
        vehiculoExistente.setModelo(vehiculo.getModelo());
        vehiculoExistente.setTipo(vehiculo.getTipo());
        vehiculoExistente.setAutorizado(vehiculo.isAutorizado());

        return vehiculoRepository.save(vehiculoExistente);
    }


    public void eliminarVehiculo(Long id) {

        Vehiculo vehiculoExistente = vehiculoRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Vehículo no encontrado: " + id)
                );

        vehiculoRepository.delete(vehiculoExistente);
    }

}