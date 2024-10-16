package ar.utn.bda.domain;

public class Modelo {
    private Integer id;
    private Marca marca;
    private String descripcion;

    public Modelo(){}

    public Modelo(Integer id, Marca marca, String descripcion) {
        this.id = id;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", marca=" + marca +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
