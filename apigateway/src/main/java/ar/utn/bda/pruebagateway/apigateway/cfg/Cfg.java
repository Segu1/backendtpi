package ar.utn.bda.pruebagateway.apigateway.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class Cfg {

    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder,
                                        @Value("${auth}") String uriAuth) {
        return builder.routes()
                .route(p -> p.path("/apiTest/**").uri(uriAuth))
                .build();
    }

}
