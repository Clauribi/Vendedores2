package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import com.example.demo.domain.Vendedor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class VendedorController {
    private Concesionario concesionario = new Concesionario();


    @PostMapping("/vendedores")
    public void altaVendedores(@Valid @RequestBody String nombre, String direccion, String dni, Integer telefono) {
        Vendedor vendedorNew = new Vendedor(nombre, direccion, dni, telefono);
        getVendedorList().put(dni, vendedorNew);
        System.out.println("El vendedor se ha dado de alta con éxito.");
    }
    @DeleteMapping("/vendedores/{dni}")
    public void bajaVendedores(@Valid @PathVariable String dni) {
        concesionario.bajaVendedor(dni);
        System.out.println("El vendedor se ha dado de baja");
    }


    @PutMapping("/vendedores/{dni}")
    public void modificarVendedores(@PathVariable String dni, @Valid @RequestBody VendedorUpdate vendedor) {
        System.out.println("El vendedor se ha modificado");
    }

    private HashMap<String, Vendedor> getVendedorList() {
        HashMap<String, Vendedor> vendedores = new HashMap<>();
        vendedores.put("123456789a",new Vendedor("Valentina","calle de las rosas 20","123456789a",609172654));
        vendedores.put("987654321b",new Vendedor("Valentin","calle de las margaritas 18","987654321b",618293746));
        return vendedores;
    }


}
