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


    @PostMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public void reservarCoche(@PathVariable String matricula, @PathVariable String dni) {
        try {
            concesionario.reservarCoche(matricula, dni);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @DeleteMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public void cancelarReserva(@PathVariable String matricula, @PathVariable String dni) {
        try {
            concesionario.cancelarReserva(matricula);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //COCHES
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

    //CLIENTES
    @PostMapping("/clientes")
    public ResponseEntity<String> altaClientes(@Valid @RequestBody ClienteInput clienteInput) {
        try {
            concesionario.addCliente(clienteInput.createDomainObject());
        } catch (ExisteExcepcion e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(concesionario.getAllClientes());
    }



}

