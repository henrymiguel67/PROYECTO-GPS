package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.Visitante;
import com.example.service.VisitanteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/visitantes")
@CrossOrigin(origins = "*")
public class VisitanteController {
    @Autowired
    private VisitanteService visitanteservice;

            @Operation(summary = "Obtener todos los Visitantes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de Visitante obtenida correctamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    @GetMapping
    public ResponseEntity<List<Visitante>> getALLVisitantes(){
        return ResponseEntity.ok(visitanteservice.getALLVisitantes());
    }
       @Operation(summary = "Buscar un Visitante por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Visitante encontrado"),
        @ApiResponse(responseCode = "404", description = "Visitante no encontrado")
    })

      @GetMapping("/{id}")
    public ResponseEntity<Visitante> getById(@PathVariable Long id) {
        return ResponseEntity.ok(visitanteservice.getVisitanteById(id));
    }
             @Operation(summary = "Registrar un nuevo Visitante")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Visitante creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

      
    @PostMapping
    public ResponseEntity<Visitante> crearVisitante(@RequestBody Visitante visitante) {
        return ResponseEntity.ok(visitanteservice.crearVisitante(visitante));
    }
    
        @Operation(summary = "Actualizar un Visitante")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Visitante actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Visitante no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })


    @PutMapping("/{id}")
    public ResponseEntity<Visitante> actualizarVisitante(@PathVariable Long id, @RequestBody Visitante visitante) {
        return ResponseEntity.ok(visitanteservice.actualizarVisitante(id, visitante));
    }

           @Operation(summary = "Eliminar un Visitante")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Visitante eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Visitante no encontrado")
    })


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVisitante(@PathVariable Long id) {
        visitanteservice.eliminarVisitante(id);
        return ResponseEntity.noContent().build();
    }



    

    
}
