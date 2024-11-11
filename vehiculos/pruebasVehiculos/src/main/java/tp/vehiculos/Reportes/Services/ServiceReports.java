package tp.vehiculos.Reportes.Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tp.vehiculos.Reportes.dto.PruebaDTO;
import tp.vehiculos.vehiculos.models.Posicion;
import tp.vehiculos.vehiculos.models.Vehiculo;
import tp.vehiculos.vehiculos.repositories.PosicionRepository;
import tp.vehiculos.vehiculos.services.ConfiguracionService;
import tp.vehiculos.vehiculos.services.PosicionService;
import tp.vehiculos.vehiculos.services.VehiculoService;

@Service
public class ServiceReports {

    private final PosicionService posicionService;
    private final RestTemplate restTemplate;
    private static final String APIPRUEBAS = "http://localhost:8083/pruebas";
    private static final String APIPRUEBAEMPLEADO = "http://localhost:8083/pruebasEmpleado";

    private final String filePath = "C:/Users/Gonzalo/Desktop/vehiculos/pruebasVehiculos/pruebasVehiculos/";

    @Autowired
    public ServiceReports(RestTemplate restTemplate, PosicionService posicionService) {
        this.posicionService = posicionService;
        this.restTemplate = restTemplate;
    }

    public void generarReporteIncidentes(){
        RestTemplate restTemplate = new RestTemplate(); 
        List<PruebaDTO> pruebas = restTemplate.getForObject(APIPRUEBAS, List.class); 
        List<Posicion> incidenList = new ArrayList<>();


        for (PruebaDTO pruebaDTO : pruebas) {
            Optional<Posicion> incidente = posicionService.obtenerEntreFechasIncidente(pruebaDTO.getFechaInicio(), pruebaDTO.getFechaFin(), pruebaDTO.getIdVehiculo());
            if(incidente.isPresent()){
                incidenList.add(incidente.get());
            }
        }
        // Especificar el nombre del archivo 
        String fileName = "reporteTotalIncidentes.csv"; 
        File file = new File(filePath + fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            incidenList.forEach(inc -> {
                printWriter.println(String.format("%s,%s,%s,%s,%s",
                        inc.getId(),
                        inc.getVehiculo().getId(),
                        inc.getFecha().toString(),
                        inc.getLatitud(),
                        inc.getLongitud()
                        ));
            });
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }   
    }


    public void generarReporteIncidentesEmpleado(){
        RestTemplate restTemplate = new RestTemplate(); 
        List<PruebaDTO> pruebas = restTemplate.getForObject(APIPRUEBAEMPLEADO, List.class); 
        List<Posicion> incidenList = new ArrayList<>();

        for (PruebaDTO pruebaDTO : pruebas) {
            Optional<Posicion> incidente = posicionService.obtenerEntreFechasIncidente(pruebaDTO.getFechaInicio(), pruebaDTO.getFechaFin(), pruebaDTO.getIdVehiculo());
            if(incidente.isPresent()){
                incidenList.add(incidente.get());
            }
        }
        String fileName = "reporteIncidentesEmpleado.csv"; 
        File file = new File(fileName + filePath);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            incidenList.forEach(inc -> {
                printWriter.println(String.format("%s,%s,%s,%s,%s",
                        inc.getId(),
                        inc.getVehiculo().getId(),
                        inc.getFecha().toString(),
                        inc.getLatitud(),
                        inc.getLongitud()
                        ));
            });
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }   
    }


}
