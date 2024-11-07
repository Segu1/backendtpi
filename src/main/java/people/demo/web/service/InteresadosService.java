package people.demo.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import people.demo.dal.InteresadoRepository;
import people.demo.domain.Interesado;
import people.demo.web.api.dto.InteresadoDTO;
import people.demo.web.api.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class InteresadosService{
    private InteresadoRepository InteresadoRepository;

    @Autowired
    public InteresadosService(InteresadoRepository rep){this.InteresadoRepository = rep;}

    public List<InteresadoDTO> findAll(){
        return InteresadoRepository.findAll().stream().map(InteresadoDTO::new).toList();
    }

    public Optional<InteresadoDTO> findById(Integer iid) {
        Optional<Interesado> interesado = InteresadoRepository.findById(iid);

        return interesado.isEmpty()
                ? Optional.empty()
                : Optional.of(new InteresadoDTO(interesado.get()));
    }

    public InteresadoDTO add(InteresadoDTO interesadoDTO) {
        Interesado interesado = InteresadoRepository.save(interesadoDTO.toEntity(interesadoDTO));
        return new InteresadoDTO(interesado);
    }

    public List<InteresadoDTO> addAll(List<InteresadoDTO> interesadoDTOS) {
        List<Interesado> interesados = InteresadoRepository.saveAll(interesadoDTOS.stream().map(indto-> indto.toEntity(indto)).toList());
        return interesados.stream().map(InteresadoDTO::new).toList();
    }

    public InteresadoDTO update(Integer iid, InteresadoDTO interesadoDTO) {
        Interesado interesado = InteresadoRepository.findById(iid).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Interesado [%d] inexistente", iid))
        );

        interesado = InteresadoRepository.save(interesado.update(interesadoDTO.toEntity(interesadoDTO)));

        return new InteresadoDTO(interesado);
    }

    public boolean deleteById(Integer iid) {
        if (!InteresadoRepository.existsById(iid)) {
            return false;
        }

        InteresadoRepository.deleteById(iid);
        return true;
    }
}
