package com.example.demo.domain;



public class Vendedor extends Persona{
    public Vendedor(String nombre, String direccion, String dni, String telefono) {
        super(nombre, direccion, dni, telefono);
    }

    public Vendedor() {
    }



    public void vendedorUpdate(String nombre, String direccion, String telefono) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
    }
}
