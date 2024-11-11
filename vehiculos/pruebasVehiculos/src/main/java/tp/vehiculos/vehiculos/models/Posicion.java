package tp.vehiculos.vehiculos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tp.vehiculos.vehiculos.dtos.PosicionDto;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posiciones")
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "id_vehiculo")
    private Vehiculo vehiculo;
    private LocalDateTime fecha;
    private double latitud;
    private double longitud;
    @Column(name="en_zona_restringida")
    private boolean enZonaRestringida;
    @Column(name="fuera_de_radio_permitido")
    private boolean fueraDeRadioPermitido;

    public Posicion(Vehiculo vehiculo, double latitud, double longitud) {
        this.vehiculo = vehiculo;
        this.latitud= latitud;
        this.longitud = longitud;
        this.fecha = LocalDateTime.now();
        this.enZonaRestringida = false;
        this.fueraDeRadioPermitido = false;
    }

    public PosicionDto toDto(){
        return new PosicionDto(getVehiculo().getId(), getLatitud(), getLongitud(),enZonaRestringida,fueraDeRadioPermitido);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void enZonaRestringida() {
        this.enZonaRestringida = true;
    }

    public void fueraDeRadio(){
        this.fueraDeRadioPermitido = true;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                ", enZonaRestringida=" + enZonaRestringida +
                ", fueraDeRadioPermitido=" + fueraDeRadioPermitido +
                '}';
    }
}
