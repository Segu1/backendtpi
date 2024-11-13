package people.demo.web.api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import people.demo.domain.Notificacion;
import people.demo.web.api.dto.NotificacionDTO;
import people.demo.web.service.NotificacionService;

@RestController
@RequestMapping("/notificarVehiculo")
public class NotificacionesAPI {
    private NotificacionService notificacionService;


    @Autowired
    public NotificacionesAPI(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @PostMapping
    public ResponseEntity<Notificacion> addNotificacion(@RequestBody @Valid NotificacionDTO notificacionDTO) {
        notificacionService.add(notificacionDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
