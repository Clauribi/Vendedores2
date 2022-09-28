package com.example.demo.controller;

import com.example.demo.domain.Coche;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CocheInput extends CocheUpdate{
    @NotNull(message = "Matricula is null")
    @NotBlank(message = "Matricula is empty")
    protected String matricula;

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
