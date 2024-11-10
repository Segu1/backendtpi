package people.demo.web.api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import people.demo.web.api.dto.EmpleadoDTO;
import people.demo.web.service.EmpleadoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadosAPI {
    private EmpleadoService empleadoService;

    @Autowired
    public EmpleadosAPI(EmpleadoService service) {
        this.empleadoService = service;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> findEmpleados() {
        List<EmpleadoDTO> empleadoDTOS = empleadoService.findAll();

        return empleadoDTOS.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(empleadoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findEmpleado(@PathVariable Integer id) {
        Optional<EmpleadoDTO> empleadoDTO = empleadoService.findById(id);

        return empleadoDTO.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(empleadoDTO.get());
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> addEmpleado(@RequestBody @Valid EmpleadoDTO empleadoDTO) {
        return new ResponseEntity<>(empleadoService.add(empleadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> updateEmpleado(
            @PathVariable Integer id,
            @Valid @RequestBody EmpleadoDTO empleadoDTO
    ) {
        return new ResponseEntity<>(empleadoService.update(id, empleadoDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmpleado(@PathVariable Integer id) {
        return empleadoService.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
