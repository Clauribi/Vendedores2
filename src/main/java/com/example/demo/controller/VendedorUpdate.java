package com.example.demo.controller;

import com.example.demo.domain.Vendedor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VendedorUpdate {
    @NotNull(message = "Nombre is null")
    @NotBlank(message = "Nombre is empty")
    protected String nombre;
    @NotNull(message = "Direccion is null")
    @NotBlank(message = "Direccion is empty")
    protected String direccion;
    @NotNull(message = "Telefono is null")
    @NotBlank(message = "Telefono is empty")
    protected String telefono;

    public VendedorUpdate(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public VendedorUpdate(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Vendedor createDomainObject(String dni) {
        return new Vendedor(this.nombre, this.direccion, dni, this.telefono);
    }
}
