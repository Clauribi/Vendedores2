package com.example.demo.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class VendedorUpdate {
    @NotNull(message = "Nombre is null")
    @NotBlank(message = "Nombre is empty")
    private String nombre;
    @NotNull(message = "Direccion is null")
    @NotBlank(message = "Direccion is empty")
    private String direccion;
    @Positive(message = "telefono is negative")
    private int telefono;

    public VendedorUpdate(String nombre, String direccion, int telefono) {
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
