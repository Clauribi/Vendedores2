package com.example.demo.controller;

import com.example.demo.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class ReservaController {
    private Concesionario concesionario = new Concesionario();


    @PostMapping("/reservas/coche/{matricula}")
    public void reservarCoche(@PathVariable String matricula) {
        try {
            concesionario.reservarCoche(matricula);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @DeleteMapping("/reservas/coche/{matricula}")
    public void cancelarReserva(@PathVariable String matricula) {
        try {
            concesionario.cancelarReserva(matricula);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //COCHESSS
    @PostMapping("/coches")
    public ResponseEntity<String> altaCoches(@Valid @RequestBody CocheInput cocheInput) {
        try {
            concesionario.addCoche(cocheInput.createDomainObject());
        } catch (ExisteExcepcion e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/coches")
    public ResponseEntity<List<Coche>> getCoches() {
        return ResponseEntity.ok(concesionario.getAllCoches());
    }

}

