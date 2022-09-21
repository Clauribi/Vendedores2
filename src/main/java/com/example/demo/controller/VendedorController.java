package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class VendedorController {
    private Concesionario concesionario = new Concesionario();

    @PostMapping("/vendedores")
    public void altaVendedores(@Valid @RequestBody String nombre, String direccion, String dni, int telefono) {
        concesionario.altaVendedor(nombre, direccion, dni, telefono);
        System.out.println("El vendedor se ha dado de alta con éxito.");
    }

}
