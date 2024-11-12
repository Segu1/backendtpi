package tp.vehiculos.Reportes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tp.vehiculos.Reportes.Services.ServiceReports;
import tp.vehiculos.vehiculos.dtos.InformeKmRequest;

@RestController
@RequestMapping("/api/reportes")
public class ReportesController {

    private final ServiceReports serviceReports;

    @Autowired
    public ReportesController(ServiceReports serviceReports) {
        this.serviceReports = serviceReports;
    }

    @GetMapping("/incidentes")
    public ResponseEntity<Void> generarReporteIncidentes() {
        serviceReports.generarReporteIncidentes();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/incidentesEmpleado") 
    public ResponseEntity<Void> generarReporteIncidentesEmpleado() 
    { serviceReports.generarReporteIncidentesEmpleado(); 
        return ResponseEntity.ok().build(); }

    @PostMapping("/informeKmRecorridos")
    public ResponseEntity<Double>  calcularKMParaVehiculoEnPeriodo(@RequestBody InformeKmRequest informeKmRequest){
        serviceReports.generarReporteCantidadKm(informeKmRequest.getFechaDesde(),informeKmRequest.getFechaHasta(), informeKmRequest.getId_vehiculo());
        return ResponseEntity.ok().build();

        /*{ "id_vehiculo": 1,
                "fecha_desde": "2023-11-07T19:47:19.385313900",
                "fecha_hasta":"2025-11-07T19:47:26.564607200"

        }*/

    }
}

