package ar.edu.utn.frc.bso.security.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path="/publico/ping")
    public String ping() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "PONG";
    }

    @GetMapping(path="/privado/ping")
    public String pingPrivado(Authentication auth) {
        return "PONG-PRIVADO-ADMIN";
    }

    @GetMapping(path="/empleado/ping")
    public String pingEmpleado(Authentication auth) {
        return "PONG-PRIVADO-EMPLEADO";
    }

}
