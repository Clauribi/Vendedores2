package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Concesionario;
import com.example.demo.domain.ExisteExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {
    private Concesionario concesionario = new Concesionario();

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
