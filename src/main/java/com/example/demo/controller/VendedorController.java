package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import com.example.demo.domain.ExisteExcepcion;
import com.example.demo.domain.NoExisteExcepcion;
import com.example.demo.domain.Vendedor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class VendedorController {
    private Concesionario concesionario = new Concesionario();

    @PostMapping("/vendedores")
    public void altaVendedores(@Valid @RequestBody String nombre, String direccion, String dni, String telefono) {
        try {
            if (concesionario.getListadoVendedores().containsKey(dni)) {
                throw new ExisteExcepcion("Ya hay un vendedor con ese DNI.");
            } else {
                concesionario.altaVendedor(nombre, direccion, dni, telefono);
                System.out.println("El vendedor se ha dado de alta con exito.");
            }
        } catch (ExisteExcepcion e) {
            System.out.println(e.getMessage());
        }
    }


    @DeleteMapping("/vendedores/{dni}")
    public void bajaVendedores(@Valid @PathVariable String dni) throws NoExisteExcepcion {
        try {
            if (concesionario.getListadoVendedores().isEmpty()) {
                System.out.println("No existen vendedores.");
            } else if (!concesionario.getListadoVendedores().containsKey(dni)) {
                throw new NoExisteExcepcion("el vendedor con dni: " + dni);
            } else {
                concesionario.bajaVendedor(dni);
                System.out.println("El vendedor se ha dado de baja");
            }
        } catch (NoExisteExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("/vendedores/{dni}")
    public void modificarVendedores(@PathVariable String dni) {
        try {
            Vendedor vendedorUpdate = concesionario.getListadoVendedores().get(dni);
            if (!concesionario.getListadoVendedores().containsKey(dni)) {
                throw new NoExisteExcepcion("el vendedor con dni: " + dni);
            } else if (vendedorUpdate != null)
                concesionario.modificarVendedor(vendedorUpdate.getNombre(), vendedorUpdate.getDireccion(), dni, vendedorUpdate.getTelefono());
            System.out.println("El vendedor se ha modificado");
        }catch (NoExisteExcepcion e){
            System.out.println(e.getMessage());
        }
    }
}
