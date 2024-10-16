package ar.utn.bda.domain;

import java.util.Date;
import java.util.Objects;

public class Prueba {
    private Interesado id;
    private Vehiculo vehiculo;
    private Interesado interesado;
    private Empleado empleado;
    private Date fecha_hora_inicio;
    private Date fecha_hora_fin;
    private String comentarios;

    public Prueba(){}

    public Prueba(Interesado id, Vehiculo vehiculo, Interesado interesado, Empleado empleado, Date fecha_hora_inicio, Date fecha_hora_fin, String comentarios) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.interesado = interesado;
        this.empleado = empleado;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.comentarios = comentarios;
    }

    public Interesado getId() {
        return id;
    }

    public void setId(Interesado id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(Date fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public Date getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public void setFecha_hora_fin(Date fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prueba prueba = (Prueba) o;
        return Objects.equals(id, prueba.id) && Objects.equals(vehiculo, prueba.vehiculo) && Objects.equals(interesado, prueba.interesado) && Objects.equals(empleado, prueba.empleado) && Objects.equals(fecha_hora_inicio, prueba.fecha_hora_inicio) && Objects.equals(fecha_hora_fin, prueba.fecha_hora_fin) && Objects.equals(comentarios, prueba.comentarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehiculo, interesado, empleado, fecha_hora_inicio, fecha_hora_fin, comentarios);
    }

    @Override
    public String toString() {
        return "Prueba{" +
                "id=" + id +
                ", vehiculo=" + vehiculo +
                ", interesado=" + interesado +
                ", empleado=" + empleado +
                ", fecha_hora_inicio=" + fecha_hora_inicio +
                ", fecha_hora_fin=" + fecha_hora_fin +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
