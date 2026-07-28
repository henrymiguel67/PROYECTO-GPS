package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository <Vehiculo, Long>{

    
    
}
