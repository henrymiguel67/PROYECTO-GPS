package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Novedad;
import com.example.service.NovedadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/novedades")
@CrossOrigin(origins = "*")
public class NovedadController {

    @Autowired
    private NovedadService novedadService;

          @Operation(summary = "Obtener todos las Novedades")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de Novedades obtenidas correctamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    @GetMapping
    public List<Novedad> getALLNovedades() {
        return novedadService.getALLNovedades();
    }

    
        @Operation(summary = "Buscar una Novedad por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Novedad encontrado"),
        @ApiResponse(responseCode = "404", description = "Novedad no encontrado")
    })

    @GetMapping("/{id}")
    public ResponseEntity<Novedad> getNovedadById(@PathVariable Long id) {
        return ResponseEntity.ok(novedadService.getNovedadById(id));
    }

    
    
        @Operation(summary = "Registrar una nueva Novedad")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Novedad creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })



    @PostMapping
    public ResponseEntity<Novedad> crearNovedad(@RequestBody Novedad novedad) {
        return ResponseEntity.ok(novedadService.crearNovedad(novedad));
    }

        @Operation(summary = "Actualizar una Novedad")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Novedad actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Novedad no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

    @PutMapping("/{id}")
    public ResponseEntity<Novedad> actualizarNovedad(@PathVariable Long id,
            @RequestBody Novedad novedad) {

        return ResponseEntity.ok(novedadService.actualizarNovedad(id, novedad));
    }

       
        @Operation(summary = "Eliminar una Novedad")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Novedad eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Novedad no encontrado")
    })


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNovedad(@PathVariable Long id) {
        novedadService.eliminarNovedad(id);
        return ResponseEntity.noContent().build();
    }

}