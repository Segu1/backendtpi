package tp.vehiculos.vehiculos.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.vehiculos.vehiculos.models.Vehiculo;
import tp.vehiculos.vehiculos.repositories.VehiculoRepository;

import java.util.List;
import java.util.Optional;


@Service
public class VehiculoService {
    private final VehiculoRepository repository;

    @Autowired
    public VehiculoService(VehiculoRepository repository) {
        this.repository = repository;
    }
    public List<Vehiculo> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Vehiculo> getVehiculoById(int id) {
        return repository.findById(id);
    }
}
