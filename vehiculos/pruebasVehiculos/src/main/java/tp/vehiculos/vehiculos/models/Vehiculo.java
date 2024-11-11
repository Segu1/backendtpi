package tp.vehiculos.vehiculos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tp.vehiculos.vehiculos.dtos.VehiculoDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patente;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;




    public VehiculoDto toDto(){
        return new VehiculoDto(id,patente);
    }

    public int getId() {
        return id;
    }

    //public iniciarPrueba(){

    //}

}


