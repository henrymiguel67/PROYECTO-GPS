package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Visitante;
import com.example.exepcion.BadRequestException;
import com.example.exepcion.ResourceNotFoundException;
import com.example.repository.VisitanteRepository;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository visitanterepository;


    public List<Visitante> getALLVisitantes() {
        return visitanterepository.findAll();
    }


    public Visitante getVisitanteById(Long id) {

        return visitanterepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visitante no encontrado: " + id));
    }


    public Visitante crearVisitante(Visitante visitante) {

        if (visitante.getNombre() == null || visitante.getNombre().isBlank()) {
            throw new BadRequestException("El nombre es obligatorio");
        }

        if (visitante.getDocumento() == null || visitante.getDocumento().isBlank()) {
            throw new BadRequestException("El documento es obligatorio");
        }

        if (visitante.getTelefono() == null || visitante.getTelefono().isBlank()) {
            throw new BadRequestException("El teléfono es obligatorio");
        }

        if (visitante.getEmpresa() == null || visitante.getEmpresa().isBlank()) {
            throw new BadRequestException("La empresa es obligatoria");
        }

        if (visitante.getMotivoVisita() == null || visitante.getMotivoVisita().isBlank()) {
            throw new BadRequestException("El motivo de la visita es obligatorio");
        }

        return visitanterepository.save(visitante);
    }


    public Visitante actualizarVisitante(Long id, Visitante visitante) {

        Visitante visitanteExistente = visitanterepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visitante no encontrado: " + id));


        if (visitante.getNombre() == null || visitante.getNombre().isBlank()) {
            throw new BadRequestException("El nombre es obligatorio");
        }

        if (visitante.getDocumento() == null || visitante.getDocumento().isBlank()) {
            throw new BadRequestException("El documento es obligatorio");
        }

        if (visitante.getTelefono() == null || visitante.getTelefono().isBlank()) {
            throw new BadRequestException("El teléfono es obligatorio");
        }

        if (visitante.getEmpresa() == null || visitante.getEmpresa().isBlank()) {
            throw new BadRequestException("La empresa es obligatoria");
        }

        if (visitante.getMotivoVisita() == null || visitante.getMotivoVisita().isBlank()) {
            throw new BadRequestException("El motivo de la visita es obligatorio");
        }


        visitanteExistente.setNombre(visitante.getNombre());
        visitanteExistente.setDocumento(visitante.getDocumento());
        visitanteExistente.setTelefono(visitante.getTelefono());
        visitanteExistente.setEmpresa(visitante.getEmpresa());
        visitanteExistente.setMotivoVisita(visitante.getMotivoVisita());
        visitanteExistente.setFechaHoraIngreso(visitante.getFechaHoraIngreso());
        visitanteExistente.setFechaHoraSalida(visitante.getFechaHoraSalida());

        return visitanterepository.save(visitanteExistente);
    }


    public void eliminarVisitante(Long id) {

        Visitante visitanteExistente = visitanterepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visitante no encontrado: " + id));

        visitanterepository.delete(visitanteExistente);
    }

}