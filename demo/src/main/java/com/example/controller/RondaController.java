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

import com.example.entities.Ronda;
import com.example.service.RondaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/rondas")
@CrossOrigin(origins = "*")
public class RondaController {
    
    @Autowired
    private RondaService rondaService;

                     @Operation(summary = "Obtener todos las Rondas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de las Rondas obtenidos correctamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    @GetMapping
    public ResponseEntity<List<Ronda>> getAllRondas() {
        return ResponseEntity.ok(rondaService.getAllRondas());
    }

            @Operation(summary = "Buscar una Ronda por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ronda encontrado"),
        @ApiResponse(responseCode = "404", description = "Ronda no encontrado")
    })

    @GetMapping("/{id}")
    public ResponseEntity<Ronda> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rondaService.getRondaById(id));
    }

         @Operation(summary = "Registrar una nueva Ronda")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ronda creada correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

    @PostMapping
    public ResponseEntity<Ronda> crearRonda(@RequestBody Ronda ronda) {
        return ResponseEntity.ok(rondaService.crearRonda(ronda));
    }

          @Operation(summary = "Actualizar una Ronda")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ronda actualizada correctamente"),
        @ApiResponse(responseCode = "404", description = "Ronda no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })


    @PutMapping("/{id}")
    public ResponseEntity<Ronda> actualizarRonda(@PathVariable Long id, @RequestBody Ronda ronda) {
        return ResponseEntity.ok(rondaService.actualizarRonda(id, ronda));
    }
         @Operation(summary = "Eliminar una Ronda")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ronda eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Ronda no encontrado")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRonda(@PathVariable Long id) {
        rondaService.eliminarRonda(id);
        return ResponseEntity.noContent().build();
    }
}
