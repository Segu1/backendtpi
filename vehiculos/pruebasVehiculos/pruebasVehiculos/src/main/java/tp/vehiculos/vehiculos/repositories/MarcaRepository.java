package tp.vehiculos.vehiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.vehiculos.vehiculos.models.Marca;

public interface MarcaRepository extends JpaRepository<Marca,Integer> {

}
