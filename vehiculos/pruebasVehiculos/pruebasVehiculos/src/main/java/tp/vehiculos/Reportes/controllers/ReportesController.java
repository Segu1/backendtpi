package tp.vehiculos.Reportes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.vehiculos.Reportes.Services.ServiceReports;

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
}

