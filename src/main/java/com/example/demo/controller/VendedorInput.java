package com.example.demo.controller;

import com.example.demo.domain.Vendedor;

public class VendedorInput extends VendedorUpdate {
    private String dni;
    public VendedorInput(String nombre, String direccion, String dni, String telefono) {
        super(nombre, direccion, telefono);
    }

    public VendedorInput() {
    }

    public Vendedor createDomainObject() {
        return new Vendedor(this.nombre, this.direccion, this.dni, this.telefono);
    }
}
