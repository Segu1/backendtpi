package ar.utn.bda.domain;

import java.util.Date;
import java.util.Objects;

public class Interesado {
    private Integer id;
    private String tipo_doc;
    private String nombre;
    private String apellido;
    private Integer restringido;
    private Integer nro_licencia;
    private Date fecha_vencimiento_licencia;

    public Interesado(){}

    public Interesado(Integer id, String tipo_doc, String nombre, String apellido, Integer restringido, Integer nro_licencia, Date fecha_vencimiento_licencia) {
        this.id = id;
        this.tipo_doc = tipo_doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.restringido = restringido;
        this.nro_licencia = nro_licencia;
        this.fecha_vencimiento_licencia = fecha_vencimiento_licencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getRestringido() {
        return restringido;
    }

    public void setRestringido(Integer restringido) {
        this.restringido = restringido;
    }

    public Integer getNro_licencia() {
        return nro_licencia;
    }

    public void setNro_licencia(Integer nro_licencia) {
        this.nro_licencia = nro_licencia;
    }

    public Date getFecha_vencimiento_licencia() {
        return fecha_vencimiento_licencia;
    }

    public void setFecha_vencimiento_licencia(Date fecha_vencimiento_licencia) {
        this.fecha_vencimiento_licencia = fecha_vencimiento_licencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interesado that = (Interesado) o;
        return Objects.equals(id, that.id) && Objects.equals(tipo_doc, that.tipo_doc) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(restringido, that.restringido) && Objects.equals(nro_licencia, that.nro_licencia) && Objects.equals(fecha_vencimiento_licencia, that.fecha_vencimiento_licencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo_doc, nombre, apellido, restringido, nro_licencia, fecha_vencimiento_licencia);
    }

    @Override
    public String toString() {
        return "Interesado{" +
                "id=" + id +
                ", tipo_doc='" + tipo_doc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", restringido=" + restringido +
                ", nro_licencia=" + nro_licencia +
                ", fecha_vencimiento_licencia=" + fecha_vencimiento_licencia +
                '}';
    }
}
