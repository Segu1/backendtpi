package tp.vehiculos.vehiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.vehiculos.vehiculos.dtos.InformeKmRequest;
import tp.vehiculos.vehiculos.dtos.PosicionDto;
import tp.vehiculos.vehiculos.services.PosicionService;

@RestController
@RequestMapping("/api/posicion")
public class PosicionController {
    private final PosicionService servicePosicion;

    @Autowired
    public PosicionController(PosicionService servicePosicion) {
        this.servicePosicion = servicePosicion;
    }

    @PostMapping("/")
    public void recibirPosicion(@RequestBody PosicionDto posicionDto) {
        servicePosicion.procesarPosicion(posicionDto);


    }

    @PostMapping("/informeKmRecorridos")
    public ResponseEntity<Double>  calcularKMParaVehiculoEnPeriodo(@RequestBody InformeKmRequest informeKmRequest){
        double cantidadKm = servicePosicion.calcularCantidadKm(informeKmRequest.getFechaDesde(),informeKmRequest.getFechaHasta(), informeKmRequest.getId_vehiculo());
        return ResponseEntity.ok(cantidadKm);

    }

    

    // Hacer un controller que reciba un arrays de pruebas y avise en cuales hubo incidente y de que tipo
    //@PostMapping("/incid











}
