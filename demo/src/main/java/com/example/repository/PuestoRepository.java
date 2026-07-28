package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Puesto;

@Repository
public interface PuestoRepository extends JpaRepository<Puesto, Long> {
List<Puesto> findByActivo(boolean activo);

}
    

