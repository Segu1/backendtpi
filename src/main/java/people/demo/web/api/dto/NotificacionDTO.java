package people.demo.web.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import people.demo.domain.Notificacion;

@Setter
@Getter
public class NotificacionDTO {

    @NotBlank(message = "La notificacion debe tener un vehiculo asociado")
    private int idVehiculo;

    private double latitud;

    private double longitud;

    private int nroTelefono;

    private boolean enZonaRestringida;

    private boolean fueraDeRadioPermitido;

    public NotificacionDTO(Notificacion notificacion){
        this.idVehiculo = notificacion.getIdVehiculo();
        this.latitud = notificacion.getLatitud();
        this.longitud = notificacion.getLongitud();
        this.nroTelefono = notificacion.getNroContacto();
    }

    public static NotificacionDTO toDTO(Notificacion notificacion) {
        if (notificacion == null) return null;
        return new NotificacionDTO(notificacion);
    }

    public Notificacion toEntity(NotificacionDTO notificacionDTO) {
        if (notificacionDTO == null) return null;

        Notificacion notificacion = new Notificacion();
        notificacion.setIdVehiculo(notificacionDTO.getIdVehiculo());
        notificacion.setLatitud(notificacionDTO.getLatitud());
        notificacion.setLongitud(notificacionDTO.getLongitud());

        if(this.enZonaRestringida){
            notificacion.setTipo("En zona restringida");
        }
        else if(this.fueraDeRadioPermitido){
            notificacion.setTipo("Fuera de radio permitido");
        }
        return notificacion;
    }
}
