package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Ronda;
import com.example.exepcion.BadRequestException;
import com.example.exepcion.ResourceNotFoundException;
import com.example.repository.RondaRepository;

@Service
public class RondaService {

    @Autowired
    private RondaRepository rondaRepository;


    public List<Ronda> getAllRondas() {
        return rondaRepository.findAll();
    }


    public Ronda getRondaById(Long id) {

        return rondaRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Ronda no encontrada: " + id)
                );
    }


    public Ronda crearRonda(Ronda ronda) {

        if (ronda.getDescripcion() == null || ronda.getDescripcion().isBlank()) {
            throw new BadRequestException("La descripción de la ronda es obligatoria");
        }

        if (ronda.getTipo() == null) {
            throw new BadRequestException("El tipo de ronda es obligatorio");
        }

        if (ronda.getEstado() == null) {
            throw new BadRequestException("El estado de la ronda es obligatorio");
        }

        if (ronda.getFechaHoraInicio() == null) {
            throw new BadRequestException("La fecha de inicio es obligatoria");
        }

        if (ronda.getFechaHoraFin() == null) {
            throw new BadRequestException("La fecha de fin es obligatoria");
        }


        return rondaRepository.save(ronda);
    }


    public Ronda actualizarRonda(Long id, Ronda ronda) {

        Ronda rondaExistente = rondaRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Ronda no encontrada: " + id)
                );


        if (ronda.getDescripcion() == null || ronda.getDescripcion().isBlank()) {
            throw new BadRequestException("La descripción de la ronda es obligatoria");
        }

        if (ronda.getTipo() == null) {
            throw new BadRequestException("El tipo de ronda es obligatorio");
        }

        if (ronda.getEstado() == null) {
            throw new BadRequestException("El estado de la ronda es obligatorio");
        }


        rondaExistente.setDescripcion(ronda.getDescripcion());
        rondaExistente.setTipo(ronda.getTipo());
        rondaExistente.setFechaHoraInicio(ronda.getFechaHoraInicio());
        rondaExistente.setFechaHoraFin(ronda.getFechaHoraFin());
        rondaExistente.setEstado(ronda.getEstado());


        return rondaRepository.save(rondaExistente);
    }


    public void eliminarRonda(Long id) {

        Ronda rondaExistente = rondaRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Ronda no encontrada: " + id)
                );


        rondaRepository.delete(rondaExistente);
    }

}