package tp.vehiculos.vehiculos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tp.vehiculos.vehiculos.configurations.ConfiguracionAgencia;

@Service
public class ConfiguracionService {

    private final RestTemplate restTemplate;
    private static final String API_URL = "https://labsys.frc.utn.edu.ar/apps-disponibilizadas/backend/api/v1/configuracion/";

    @Autowired
    public ConfiguracionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ConfiguracionAgencia obtenerConfiguration() {
        ConfiguracionAgencia agencia = restTemplate.getForObject(API_URL, ConfiguracionAgencia.class);
        return agencia;
    }
}
