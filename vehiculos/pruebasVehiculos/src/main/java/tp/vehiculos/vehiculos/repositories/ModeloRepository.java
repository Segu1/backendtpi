package tp.vehiculos.vehiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.vehiculos.vehiculos.models.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo,Integer> {
}
