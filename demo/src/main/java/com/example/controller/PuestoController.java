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

import com.example.entities.Puesto;
import com.example.service.PuestoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/puestos")
@CrossOrigin(origins = "*")
public class PuestoController {

    @Autowired
    private PuestoService puestoService;

              @Operation(summary = "Obtener todos los Puestos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de los Puestos obtenidos correctamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    @GetMapping
    public List<Puesto> getAllPuestos() {
        return puestoService.getAllPuestos();
    }

            @Operation(summary = "Buscar un Puesto por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Puesto encontrado"),
        @ApiResponse(responseCode = "404", description = "Puesto no encontrado")
    })

    @GetMapping("/{id}")
    public ResponseEntity<Puesto> getPuestoById(@PathVariable Long id) {            
        return ResponseEntity.ok(puestoService.getPuestoById(id));
    }

        
        @Operation(summary = "Registrar un nuevo Puesto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Puesto creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })


    @PostMapping
    public ResponseEntity<Puesto> crearPuesto(@RequestBody Puesto puesto) {
        return ResponseEntity.ok(puestoService.crearPuesto(puesto));
    }

           @Operation(summary = "Actualizar un Puesto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Puesto actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Puesto no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

    @PutMapping("/{id}")
    public ResponseEntity<Puesto> actualizarPuesto(@PathVariable Long id, @RequestBody Puesto puesto) {
        return ResponseEntity.ok(puestoService.actualizarPuesto(id, puesto));
    }
       @Operation(summary = "Eliminar un Puesto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Puesto eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Puesto no encontrado")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPuesto(@PathVariable Long id) {
        puestoService.eliminarPuesto(id);
        return ResponseEntity.noContent().build();
    }

}
