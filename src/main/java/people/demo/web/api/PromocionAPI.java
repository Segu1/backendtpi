package people.demo.web.api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import people.demo.web.api.dto.PromocionDTO;
import people.demo.web.service.PromocionService;

@RestController
@RequestMapping("/notificarPromocion")
public class PromocionAPI {
    private PromocionService promocionService;


    @Autowired
    public PromocionAPI(PromocionService promocionService) {
        this.promocionService = promocionService;
    }

    @PostMapping
    public ResponseEntity<PromocionDTO> addNotificacion(@RequestBody @Valid PromocionDTO promocionDTO) {
        return new ResponseEntity<>(promocionService.add(promocionDTO), HttpStatus.CREATED);
    }

}
