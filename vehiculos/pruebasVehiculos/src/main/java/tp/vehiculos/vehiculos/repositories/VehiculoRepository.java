package tp.vehiculos.vehiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.vehiculos.vehiculos.models.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer> {
}
