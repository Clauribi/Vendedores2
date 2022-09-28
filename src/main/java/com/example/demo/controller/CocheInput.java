package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Coche;

public class CocheInput extends CocheUpdate{
    private String matricula;

    public CocheInput(String marca, String modelo, String matricula) {
        super(marca, modelo);
        this.matricula = matricula;
    }

    public CocheInput() {
    }

    public String getMatricula() {
        return matricula;
    }
    public Coche createDomainObject() {
        return new Coche(this.marca, this.modelo, this.matricula);
    }
}
