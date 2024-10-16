package ar.utn.bda.domain;

import java.util.Date;
import java.util.Objects;

public class Posicion {
    private Integer id;
    private Vehiculo vehiculo;
    private Date fecha_hora;
    private Integer latitud;
    private Integer longitud;

    public Posicion(){}

    public Posicion(Integer id, Vehiculo vehiculo, Date fecha_hora, Integer latitud, Integer longitud) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.fecha_hora = fecha_hora;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return Objects.equals(id, posicion.id) && Objects.equals(vehiculo, posicion.vehiculo) && Objects.equals(fecha_hora, posicion.fecha_hora) && Objects.equals(latitud, posicion.latitud) && Objects.equals(longitud, posicion.longitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehiculo, fecha_hora, latitud, longitud);
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "id=" + id +
                ", vehiculo=" + vehiculo +
                ", fecha_hora=" + fecha_hora +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
