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
    public void altaVendedores(@Valid @RequestBody VendedorInput vendedorInput) {
        try {
            concesionario.addVendedor(vendedorInput.createDomainObject());
        } catch (ExisteExcepcion e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/vendedores/{dni}")
    public void bajaVendedores(@PathVariable String dni) throws NoExisteExcepcion {
        try {
            concesionario.deleteVendedor(dni);

        } catch (NoExisteExcepcion e) {
            System.out.println(e.getMessage());
        }
    }
    
    @PutMapping("/vendedores/{dni}")
    public void modificarVendedores(@PathVariable String dni,@Valid @RequestBody VendedorUpdate vendedorUpdate ) {
        try {
            Vendedor vendedor = vendedorUpdate.createDomainObject(dni);
                concesionario.updateVendedor(vendedor);
        } catch (NoExisteExcepcion e) {
            System.out.println(e.getMessage());
        }
    }
}
