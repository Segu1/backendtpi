package ar.utn.bda.domain;

import java.util.Objects;

public class Vehiculo {
    private Integer id;
    private String patente;
    private Modelo modelo;

    public Vehiculo(){}

    public Vehiculo(Integer id, String patente, Modelo modelo) {
        this.id = id;
        this.patente = patente;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(id, vehiculo.id) && Objects.equals(patente, vehiculo.patente) && Objects.equals(modelo, vehiculo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patente, modelo);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", patente='" + patente + '\'' +
                ", modelo=" + modelo +
                '}';
    }
}
