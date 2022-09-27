package com.example.demo.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Persona {
    @NotNull(message = "Nombre is null")
    @NotBlank(message = "Nombre is empty")
    private String nombre;
    @NotNull(message = "Direccion is null")
    @NotBlank(message = "Direccion is empty")
    private String direccion;
    @NotNull(message = "Dni is null")
    @NotBlank(message = "Dni is empty")
    private String dni;
    @NotNull(message = "Telefono is null")
    @NotBlank(message = "Telefono is empty")
    private String telefono;

    public Persona(String nombre, String direccion, String dni, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }
    public Persona(){

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
