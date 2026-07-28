package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Reporte;
import com.example.exepcion.BadRequestException;
import com.example.exepcion.ResourceNotFoundException;
import com.example.repository.ReporteRepository;

@Service
public class ReporteService {

    @Autowired 
    private ReporteRepository reporteRepository;


    public List<Reporte> getAllReportes() {
        return reporteRepository.findAll();
    }


    public Reporte getReporteById(Long id) {

        return reporteRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Reporte no encontrado: " + id)
                );
    }


    public Reporte crearReporte(Reporte reporte) {

        if (reporte.getTitulo() == null || reporte.getTitulo().isBlank()) {
            throw new BadRequestException("El título del reporte es obligatorio");
        }

        if (reporte.getDescripcion() == null || reporte.getDescripcion().isBlank()) {
            throw new BadRequestException("La descripción del reporte es obligatoria");
        }

        if (reporte.getTipo() == null) {
            throw new BadRequestException("El tipo de reporte es obligatorio");
        }

        if (reporte.getEstado() == null) {
            throw new BadRequestException("El estado del reporte es obligatorio");
        }


        return reporteRepository.save(reporte);
    }


    public Reporte actualizarReporte(Long id, Reporte reporte) {

        Reporte reporteExistente = reporteRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Reporte no encontrado: " + id)
                );


        if (reporte.getTitulo() == null || reporte.getTitulo().isBlank()) {
            throw new BadRequestException("El título del reporte es obligatorio");
        }

        if (reporte.getDescripcion() == null || reporte.getDescripcion().isBlank()) {
            throw new BadRequestException("La descripción del reporte es obligatoria");
        }

        if (reporte.getTipo() == null) {
            throw new BadRequestException("El tipo de reporte es obligatorio");
        }

        if (reporte.getEstado() == null) {
            throw new BadRequestException("El estado del reporte es obligatorio");
        }


        reporteExistente.setTitulo(reporte.getTitulo());
        reporteExistente.setDescripcion(reporte.getDescripcion());
        reporteExistente.setFechaHora(reporte.getFechaHora());
        reporteExistente.setTipo(reporte.getTipo());
        reporteExistente.setEstado(reporte.getEstado());


        return reporteRepository.save(reporteExistente);
    }


    public void eliminarReporte(Long id) {

        Reporte reporteExistente = reporteRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Reporte no encontrado: " + id)
                );

        reporteRepository.delete(reporteExistente);
    }

}