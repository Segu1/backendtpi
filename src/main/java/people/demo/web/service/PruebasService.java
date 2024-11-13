package people.demo.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import people.demo.dal.EmpleadoRepository;
import people.demo.dal.InteresadoRepository;
import people.demo.dal.PruebaRepository;
import people.demo.domain.Empleado;
import people.demo.domain.Interesado;
import people.demo.domain.Prueba;
import people.demo.web.api.dto.PruebaDTO;
import people.demo.web.api.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PruebasService {
    private final PruebaRepository pruebaRepository;
    private final InteresadoRepository interesadoRepository;
    private final EmpleadoRepository empleadoRepository;
    @Autowired
    public PruebasService(PruebaRepository pruebaReposotoryosotory, InteresadoRepository interesadoRepository, EmpleadoRepository empleadoRepository){
        this.pruebaRepository = pruebaReposotoryosotory;
        this.interesadoRepository = interesadoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public List<PruebaDTO> findAll(){
        return pruebaRepository.findAll().stream().map(PruebaDTO::new).toList();
    }

    public Optional<PruebaDTO> findById(Integer pid) {
        Optional<Prueba> prueba = pruebaRepository.findById(pid);

        return prueba.isEmpty()
                ? Optional.empty()
                : Optional.of(new PruebaDTO(prueba.get()));
    }

    public PruebaDTO add(PruebaDTO pruebaDTO) throws NullPointerException {

        Optional<Interesado> interesadoOpt = interesadoRepository.findById(pruebaDTO.getId_interesado());
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(pruebaDTO.getLegajo_empleado());
        //interesado

        Interesado interesado = interesadoOpt.get(); // Lanza excepción si está vacío
        Empleado empleado = empleadoOpt.get();
        Prueba prueba = pruebaRepository.save(PruebaDTO.toEntity(pruebaDTO, interesado, empleado)); //Interesado to entity viola la ley de demeter
        return new PruebaDTO(prueba);
    }

    public Interesado buscarInteresado(int id){
        Optional<Interesado> Optinteresado = interesadoRepository.findById(id);
        return Optinteresado.orElse(null);
    }

    public Empleado buscarEmpleado(int id){
        Optional<Empleado> optEmpleado = empleadoRepository.findById(id);
        return optEmpleado.orElse(null);
    }

    public List<PruebaDTO> addAll(List<PruebaDTO> pruebaDTOS) {

        List<Prueba> pruebas = pruebaRepository.saveAll(
                pruebaDTOS.stream()
                        .map(pruebaDTO -> PruebaDTO.toEntity(pruebaDTO, buscarInteresado(pruebaDTO.getId_interesado()),
                                buscarEmpleado(pruebaDTO.getLegajo_empleado())))
                        .toList() // Convert the Stream to a List
        );

        return pruebas.stream().map(PruebaDTO::new).toList();
    }

    public PruebaDTO update (Integer pid, PruebaDTO pruebaDTO) throws NullPointerException{

        //REVISAR----------------------------------------------------
        Interesado interesado = buscarInteresado(pruebaDTO.getId_interesado());
        Empleado empleado = buscarEmpleado(pruebaDTO.getLegajo_empleado());

        //interesado


        //-------------------------------------------------------------

        Prueba prueba = pruebaRepository.findById(pid).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Prueba [%d] inexistente", pid))
        );

       prueba.setComentarios(pruebaDTO.getComentarios());
       prueba.setInteresado(interesado);
       prueba.setEmpleado(empleado);
       prueba.setFechaHoraFin(pruebaDTO.getFechaHoraFin());
       prueba.setFechaHoraInicio(pruebaDTO.getFechaHoraInicio());

        return new PruebaDTO(prueba);
    }

    public boolean deleteById(Integer pid) {
        if (!pruebaRepository.existsById(pid)) {
            return false;
        }

        pruebaRepository.deleteById(pid);
        return true;
    }
}



