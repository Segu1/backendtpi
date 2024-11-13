package people.demo.web.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import people.demo.dal.InteresadoRepository;
import people.demo.dal.PromocionRepository;
import people.demo.domain.Interesado;
import people.demo.domain.Promocion;
import people.demo.web.api.dto.PromocionDTO;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PromocionService {
    private final PromocionRepository promocionRepository;
    private InteresadoRepository interesadoRepository;
    @Autowired
    public PromocionService(PromocionRepository promocionRepository, InteresadoRepository interesadoRepository){
        this.promocionRepository  = promocionRepository;
        this.interesadoRepository = interesadoRepository;
    }

    public PromocionDTO add(@Valid PromocionDTO promocionDTO){
        Set<String> emailInteresados = interesadoRepository.findAll()
                .stream()
                .filter(interesado -> !interesado.getRestringido()) // Filtrar interesados no restringidos
                .map(Interesado::getEmail) // Transformar cada Interesado a su nombre
                .collect(Collectors.toSet());

        Promocion promocion = promocionDTO.toEntity(promocionDTO);
        promocion.setEmails(emailInteresados);
        promocionRepository.save(promocion);

        return new PromocionDTO(promocion);
    }

}
