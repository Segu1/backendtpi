package tp.vehiculos.Reportes.Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tp.vehiculos.Reportes.dto.PruebaDTO;
import tp.vehiculos.vehiculos.models.Marca;
import tp.vehiculos.vehiculos.models.Modelo;
import tp.vehiculos.vehiculos.models.Posicion;
import tp.vehiculos.vehiculos.models.Vehiculo;
import tp.vehiculos.vehiculos.repositories.PosicionRepository;
import tp.vehiculos.vehiculos.services.ConfiguracionService;
import tp.vehiculos.vehiculos.services.PosicionService;
import tp.vehiculos.vehiculos.services.VehiculoService;

import static java.lang.String.format;

@Service
public class ServiceReports {

    private final PosicionService posicionService;
    private final RestTemplate restTemplate;
    private static final String APIPRUEBAS = "http://localhost:8083/pruebas";
    private static final String APIPRUEBAEMPLEADO = "http://localhost:8083/pruebasEmpleado";

    private final String filePath = "C:/Users/Gonzalo/Desktop/vehiculos/pruebasVehiculos/pruebasVehiculos/";
    private static List<PruebaDTO> pruebaDTOS = new ArrayList<>();
    private static final PruebaDTO prueba1 = new PruebaDTO("ok", new Date(), new Date(),2,  3, 4, 7 );
    private static final PruebaDTO prueba2 = new PruebaDTO("ok", new Date(), new Date(),6,  3, 2, 8 );
    private static final PruebaDTO prueba3 = new PruebaDTO("ok", new Date(), new Date(),7,  4, 1, 9 );


    @Autowired
    public ServiceReports(RestTemplate restTemplate, PosicionService posicionService) {
        this.posicionService = posicionService;
        this.restTemplate = restTemplate;
    }

    public void generarReporteIncidentes(){
        RestTemplate restTemplate = new RestTemplate(); 
        //List<PruebaDTO> pruebas = restTemplate.getForObject(APIPRUEBAS, List.class);
        pruebaDTOS.add(prueba1);
        pruebaDTOS.add(prueba2);
        pruebaDTOS.add(prueba3);
        List<Posicion> incidenList = new ArrayList<>();


        for (PruebaDTO pruebaDTO : pruebaDTOS) {
            Optional<Posicion> incidente = posicionService.obtenerEntreFechasIncidente(pruebaDTO.getFechaInicio(), pruebaDTO.getFechaFin(), pruebaDTO.getIdVehiculo());
            if(incidente.isPresent()){
                incidenList.add(incidente.get());
            }
        }
        // Especificar el nombre del archivo
        Marca mar = new Marca(2, "fer");
        Modelo modelo = new Modelo(1,"forFierta",mar);
        Vehiculo vehiculo = new Vehiculo(2,"ferTieneSueño",modelo);
        Posicion pos = new Posicion(9, vehiculo, LocalDateTime.now(), 22.2222, 45.22, false, false);
        incidenList.add(pos);
        String fileName = "reporteTotalIncidentes.csv"; 
        File file = new File(filePath + fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(format("%s %s %s %s %s", "IDIncidente","IDVehículo","Fecha","Latitud","Longitud"));
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
            printWriter.println(format("%s %s %s %s %s", "IDIncidente","IDVehículo","Fecha","Latitud","Longitud"));
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
