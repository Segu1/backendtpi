package tp.vehiculos.vehiculos.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class VehiculoDto {
    private int id;
    private String patente;

    public VehiculoDto(int id, String patente) {
        this.id = id;
        this.patente = patente;
    }

    // private Set<PruebaDto> pruebas;
    //private ModeloDto modelo;
    //private Set<PosicionDto> posiciones;

    /*public VehiculoDto(int id, String patente){
        this.id = id;
        this.patente = patente;
    }*/
}
