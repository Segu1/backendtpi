package people.demo.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import people.demo.dal.NotificacionRepository;
import people.demo.dal.PruebaReposotory;
import people.demo.domain.Prueba;
import people.demo.web.api.dto.NotificacionDTO;

@Service
public class NotificacionService {
    private NotificacionRepository notificacionRepository;
    private PruebaReposotory pruebaReposotory;
    @Autowired
    public NotificacionService(NotificacionRepository notificacionRepository, PruebaReposotory pruebaReposotory){
        this.notificacionRepository = notificacionRepository;
        this.pruebaReposotory = pruebaReposotory;
    };

    public void add(NotificacionDTO notificacionDTO) {
     Prueba pruebaActual = pruebaReposotory.findPruebaActual(notificacionDTO.getIdVehiculo());
     notificacionDTO.setNroTelefono(pruebaActual.getEmpleado().getTelefonoContacto());
     notificacionRepository.save(notificacionDTO.toEntity(notificacionDTO));
    }

}
