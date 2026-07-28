package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Ronda;
import com.example.entities.TipoRonda;

@Repository
public interface RondaRepository extends JpaRepository <Ronda, Long>  {

    List<Ronda> findByTipo(TipoRonda tipo);

}
