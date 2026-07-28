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

import com.example.entities.Reporte;
import com.example.service.ReporteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

                  @Operation(summary = "Obtener todos los Reportes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de los Reportes obtenidos correctamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    @GetMapping
    public List<Reporte> getAllReportes() {
        return reporteService.getAllReportes();
    }

            @Operation(summary = "Buscar un Reporte por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Reporte encontrado"),
        @ApiResponse(responseCode = "404", description = "Reporte no encontrado")
    })


    @GetMapping("/{id}")
   public ResponseEntity<Reporte> getPuestoById(@PathVariable Long id) {            
        return ResponseEntity.ok(reporteService.getReporteById(id));
    }

         
        @Operation(summary = "Registrar un nuevo Reporte")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Reporte creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })


    @PostMapping 
    public ResponseEntity <Reporte> crearReporte(@RequestBody Reporte reporte ){
        return ResponseEntity.ok(reporteService.crearReporte(reporte));
    }

    
           @Operation(summary = "Actualizar un Reporte")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Reporte actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Reporte no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })


    @PutMapping ("/{id}")
    public ResponseEntity <Reporte> actualizarReporte(@PathVariable Long id , @RequestBody Reporte reporte){
        return ResponseEntity.ok(reporteService.actualizarReporte(id, reporte));
    }
         @Operation(summary = "Eliminar un Reporte")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Reporte eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Reporte no encontrado")
    })
    
    @DeleteMapping("/{id}")
    public ResponseEntity  <Reporte> eliminarReporte(@PathVariable long id){
       reporteService.eliminarReporte(id);
       return ResponseEntity.noContent().build();
    }

    
}
