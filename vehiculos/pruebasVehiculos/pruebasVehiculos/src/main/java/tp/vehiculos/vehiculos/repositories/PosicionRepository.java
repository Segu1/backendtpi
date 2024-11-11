package tp.vehiculos.vehiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp.vehiculos.vehiculos.models.Posicion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PosicionRepository extends JpaRepository<Posicion,Integer> {

    @Query("SELECT p FROM Posicion p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin AND p.vehiculo.id = :idVehiculo")
    List<Posicion> findByFechaBetweenAndVehiculoId(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                   @Param("fechaFin") LocalDateTime fechaFin,
                                                   @Param("idVehiculo") int idVehiculo);


    @Query("SELECT p FROM Posicion p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin AND p.vehiculo.id = :idVehiculo AND (p.estaFueraDeRadio = true OR p.enZonaPeligrosa = true)")
    Optional<Posicion> findIncidente(@Param("fechaInicio") LocalDateTime fechaInicio,
                                     @Param("fechaFin") LocalDateTime fechaFin,
                                     @Param("idVehiculo") int idVehiculo);

}