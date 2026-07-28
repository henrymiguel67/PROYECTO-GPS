package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Novedad;
import com.example.exepcion.BadRequestException;
import com.example.exepcion.ResourceNotFoundException;
import com.example.repository.NovedadRepository;

@Service
public class NovedadService {

    @Autowired
    private NovedadRepository novedadRepository;


    public List<Novedad> getALLNovedades() {
        return novedadRepository.findAll();
    }


    public Novedad getNovedadById(Long id) {

        return novedadRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Novedad no encontrada: " + id)
                );
    }


    public Novedad crearNovedad(Novedad novedad) {

        if (novedad.getTitulo() == null || novedad.getTitulo().isBlank()) {
            throw new BadRequestException("El título es obligatorio");
        }

        if (novedad.getDescripcion() == null || novedad.getDescripcion().isBlank()) {
            throw new BadRequestException("La descripción es obligatoria");
        }

        if (novedad.getEstado() == null) {
            throw new BadRequestException("El estado es obligatorio");
        }


        return novedadRepository.save(novedad);
    }


    public Novedad actualizarNovedad(Long id, Novedad novedad) {

        Novedad novedadExistente = novedadRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Novedad no encontrada: " + id)
                );


        if (novedad.getTitulo() == null || novedad.getTitulo().isBlank()) {
            throw new BadRequestException("El título es obligatorio");
        }

        if (novedad.getDescripcion() == null || novedad.getDescripcion().isBlank()) {
            throw new BadRequestException("La descripción es obligatoria");
        }

        if (novedad.getEstado() == null) {
            throw new BadRequestException("El estado es obligatorio");
        }


        novedadExistente.setTitulo(novedad.getTitulo());
        novedadExistente.setDescripcion(novedad.getDescripcion());
        novedadExistente.setFechaHora(novedad.getFechaHora());
        novedadExistente.setEstado(novedad.getEstado());


        return novedadRepository.save(novedadExistente);
    }


    public void eliminarNovedad(Long id) {

        Novedad novedadExistente = novedadRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Novedad no encontrada: " + id)
                );

        novedadRepository.delete(novedadExistente);
    }

}