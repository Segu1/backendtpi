package tp.vehiculos.vehiculos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PosicionDto {
    //private int id;
    private int idVehiculo;
    //private LocalDateTime fecha_hora;
    private double latitud;
    private double longitud;
    private boolean enZonaRestringida;
    private boolean fueraDeRadioPermitido;

    public PosicionDto(int idVehiculo, double latitud, double longitud, boolean enZonaRestringida, boolean fueraDeRadioPermitido) {
        this.idVehiculo = idVehiculo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.enZonaRestringida = enZonaRestringida;
        this.fueraDeRadioPermitido = fueraDeRadioPermitido;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
