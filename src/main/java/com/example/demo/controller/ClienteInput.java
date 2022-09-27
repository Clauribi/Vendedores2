package com.example.demo.controller;

import com.example.demo.domain.Cliente;

public class ClienteInput extends ClienteUpdate{
    private String dni;

    public ClienteInput(String nombre, String direccion,String dni, String telefono) {
        super(nombre, direccion, telefono);
        this.dni= dni;
    }

    public ClienteInput() {
    }

    public String getDni() {
        return dni;
    }
    public Cliente createDomainObject() {
        return new Cliente(this.nombre, this.direccion, this.dni, this.telefono);
    }
}
