package tp.vehiculos.Reportes.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.ZoneId;



import java.util.Date;

public class PruebaDTO {
    private Integer id;

    private Integer id_interesado;

    private Integer legajo_empleado;

    private Integer idVehiculo;

    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    
    private String comentarios;



    public LocalDateTime getFechaInicio() {

        return fechaHoraInicio.toInstant().atZone(ZoneId.systemDefault()) .toLocalDateTime(); 
    }

    public LocalDateTime getFechaFin() {
        return fechaHoraFin.toInstant().atZone(ZoneId.systemDefault()) .toLocalDateTime(); 
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    

}