package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import com.example.demo.domain.ExisteExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class CocheController {
    private Concesionario concesionario = new Concesionario();

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
}
