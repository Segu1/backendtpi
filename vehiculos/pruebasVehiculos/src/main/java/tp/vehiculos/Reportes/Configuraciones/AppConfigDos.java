
package tp.vehiculos.Reportes.Configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigDos {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


