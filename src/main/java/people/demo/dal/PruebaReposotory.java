package people.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import people.demo.domain.Prueba;

public interface PruebaReposotory extends JpaRepository<Prueba, Integer> {
     @Query("SELECT p FROM Prueba p WHERE p.idVehiculo = :idVehiculo AND p.fechaHoraFin IS NULL")
     Prueba findPruebaActual(@Param("idVehiculo") int idVehiculo);
    }
