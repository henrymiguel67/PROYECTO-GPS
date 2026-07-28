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
import com.example.entities.Vehiculo;
import com.example.service.VehiculoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

          @Operation(summary = "Obtener todos los Vehiculos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de Vehiculos obtenida correctamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getALLVehiculos(){
        return ResponseEntity.ok(vehiculoService.getALLVehiculos());
    }

      @Operation(summary = "Buscar un Vehiculo por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehiculo encontrado"),
        @ApiResponse(responseCode = "404", description = "Vehiculo no encontrado")
    })
    
  @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.getVehiculoById(id));
    }
         @Operation(summary = "Registrar un nuevo Vehiculo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Vehiculo creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

    @PostMapping
    public ResponseEntity<Vehiculo> crearVehiculo(@RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(vehiculoService.crearVehiculo(vehiculo));
    } 
        @Operation(summary = "Actualizar un Vehiculo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehiculo actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Vehiculo no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })


    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(vehiculoService.actualizarVehiculo(id, vehiculo));
    }
    
        @Operation(summary = "Eliminar un Vehiculo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehiculo eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Vehiculo no encontrado")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Long id) {
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }


    
}
