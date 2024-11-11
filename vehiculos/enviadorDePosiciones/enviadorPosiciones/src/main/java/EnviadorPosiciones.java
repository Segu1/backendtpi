import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class EnviadorPosiciones {

    private static final String URL_API = "http://localhost:8084/api/posicion/";

    public static void main(String[] args) {
        EnviadorPosiciones enviador = new EnviadorPosiciones();
        enviador.enviarPosiciones();
    }

    public void enviarPosiciones() {
        // Array 1: Movimiento dentro del radio permitido y evitando zonas restringidas
        List<String> posicionesDentroDeRadio = List.of(
                "{\"idVehiculo\":1,\"latitud\":42.50886738457441,\"longitud\":1.5347139324337429}",
                "{\"idVehiculo\":1,\"latitud\":42.509000,\"longitud\":1.53473000}",
                "{\"idVehiculo\":1,\"latitud\":42.509100,\"longitud\":1.53474000}",
                "{\"idVehiculo\":1,\"latitud\":42.509200,\"longitud\":1.53475000}",
                "{\"idVehiculo\":1,\"latitud\":42.509300,\"longitud\":1.53476000}"
        );

        // Array 2: Comienza dentro del radio, pero sale progresivamente
        List<String> posicionesSalidaDeRadio = List.of(
                "{\"idVehiculo\":2,\"latitud\":42.508900,\"longitud\":1.53472000}",
                "{\"idVehiculo\":2,\"latitud\":42.509400,\"longitud\":1.53480000}",
                "{\"idVehiculo\":2,\"latitud\":42.509800,\"longitud\":1.53490000}",
                "{\"idVehiculo\":2,\"latitud\":42.510000,\"longitud\":1.53500000}",
                "{\"idVehiculo\":2,\"latitud\":42.510500,\"longitud\":1.53510000}",
                "{\"idVehiculo\":2,\"latitud\":42.520500,\"longitud\":1.53510000}",
                "{\"idVehiculo\":2,\"latitud\":42.530500,\"longitud\":1.53510000}",
                "{\"idVehiculo\":2,\"latitud\":42.540500,\"longitud\":1.53510000}",
                "{\"idVehiculo\":2,\"latitud\":42.550500,\"longitud\":1.53510000}",
                "{\"idVehiculo\":2,\"latitud\":42.560500,\"longitud\":1.53510000}",
                "{\"idVehiculo\":2,\"latitud\":42.570500,\"longitud\":1.53510000}"
        );

        // Enviar posiciones dentro del radio
        posicionesDentroDeRadio.forEach(this::enviarPosicionJson);

        // Enviar posiciones que salen del radio
        posicionesSalidaDeRadio.forEach(this::enviarPosicionJson);
    }

    private void enviarPosicionJson(String posicionJson) {
        RestTemplate restTemplate = new RestTemplate();

        // Configurar encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la solicitud con el JSON como contenido
        HttpEntity<String> request = new HttpEntity<>(posicionJson, headers);

        // Enviar la solicitud
        ResponseEntity<Void> response = restTemplate.postForEntity(URL_API, request, Void.class);
    }
}




