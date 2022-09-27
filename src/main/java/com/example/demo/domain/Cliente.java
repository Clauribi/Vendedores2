package com.example.demo.domain;

import java.util.HashMap;

public class Cliente extends Persona{
    private HashMap<String, Coche> reservados = new HashMap<>();

    public HashMap<String, Coche> getReservados() {
        return reservados;
    }

    public Cliente(String nombre, String direccion, String dni, String telefono) {
        super(nombre, direccion, dni, telefono);
    }

    public Cliente() {
    }

    public void agregarCocheReservado(Coche coche) {
        this.reservados.put(coche.getMatricula(), coche);
    }
}
