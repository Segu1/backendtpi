package people.demo.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "NOTIFICACIONES")
@Getter
@Setter
@ToString

public class Notificacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idVehiculo;

    private double latitud;

    private double longitud;

    private String tipo;

    private int nroContacto;
    public Notificacion(){};


    public Notificacion(int id, int idVehiculo, double latitud, double longitud, String tipo, int nroContacto) {
        this.id = id;
        this.idVehiculo = idVehiculo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipo = tipo;
        this.nroContacto = nroContacto;
    }
}
