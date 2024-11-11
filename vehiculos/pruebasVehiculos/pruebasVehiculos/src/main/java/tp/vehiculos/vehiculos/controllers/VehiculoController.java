package tp.vehiculos.vehiculos.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.vehiculos.vehiculos.dtos.VehiculoDto;
import tp.vehiculos.vehiculos.models.Vehiculo;
import tp.vehiculos.vehiculos.services.VehiculoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    private final VehiculoService service;

    @Autowired
    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDto>> obtenerVehiculos() {
        List<Vehiculo> vehiculos = service.obtenerTodos();
        List<VehiculoDto> vehiculosDto = vehiculos.stream().map(v->v.toDto()).collect(Collectors.toList());
        return ResponseEntity.ok(vehiculosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDto> obtenerVehiculoPorId(@PathVariable int id) {
        return service.getVehiculoById(id)
                .map(vehiculo -> ResponseEntity.ok(vehiculo.toDto()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}