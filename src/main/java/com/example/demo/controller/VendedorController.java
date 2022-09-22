package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import com.example.demo.domain.NoExisteExcepcion;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class VendedorController {
    private Concesionario concesionario = new Concesionario();

    @PostMapping("/vendedores")
    public void altaVendedores(@Valid @RequestBody String nombre, String direccion, String dni, int telefono) {
        concesionario.altaVendedor(nombre, direccion, dni, telefono);
        System.out.println("El vendedor se ha dado de alta con éxito.");
    }
    @DeleteMapping("/vendedores/{dni}")
    public void bajaVendedores(@PathVariable String dni) throws NoExisteExcepcion {
        if (concesionario.getListadoVendedores().isEmpty()) {
            System.out.println("No existen vendedores.");
        }else {
            if (concesionario.noExisteVendedor(dni)){
                System.out.println(" el vendedor.");
            } else {
                concesionario.bajaVendedor(dni);
                System.out.println("El vendedor se ha dado de baja");
            }
        }
    }
    @PutMapping("/vendedores/{dni}")
    public void modificarVendedores(@PathVariable String dni, @Valid @RequestBody VendedorUpdate vendedor) {


        System.out.println("El vendedor se ha modificado");

    }

}
