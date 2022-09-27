package com.example.demo.domain;


import com.example.demo.controller.VendedorUpdate;

public class Vendedor extends Persona{
    public Vendedor(String nombre, String direccion, String dni, String telefono) {
        super(nombre, direccion, dni, telefono);
    }

    public void updateFromVendedorUpdate(VendedorUpdate vendedor) {
        vendedor.createDomainObject(dni);
    }
}
