package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.EstadoNovedad;
import com.example.entities.Novedad;

@Repository
public interface NovedadRepository extends JpaRepository<Novedad, Long> {

    List<Novedad> findByEstado(EstadoNovedad estado);

}