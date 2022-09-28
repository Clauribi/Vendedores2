package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import com.example.demo.domain.ExisteExcepcion;
import com.example.demo.domain.NoExisteExcepcion;
import com.example.demo.domain.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VendedorController {
    private Concesionario concesionario = new Concesionario();

    @PostMapping("/vendedores")
    public ResponseEntity<String> altaVendedores(@Valid @RequestBody VendedorInput vendedorInput) {
        try {
            concesionario.addVendedor(vendedorInput.createDomainObject());
        } catch (ExisteExcepcion e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/vendedores/{dni}")
    public void bajaVendedores(@PathVariable String dni) {
        try {
            concesionario.deleteVendedor(dni);

        } catch (NoExisteExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("/vendedores/{dni}")
    public void modificarVendedores(@PathVariable String dni, @Valid @RequestBody VendedorUpdate vendedorUpdate) {
        try {
            Vendedor vendedor = vendedorUpdate.createDomainObject(dni);
            concesionario.updateVendedor(vendedor);
        } catch (NoExisteExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/vendedores")
    public ResponseEntity<List<Vendedor>> getVendedores() {
        return ResponseEntity.ok(concesionario.getAllVendedores());
    }
}
