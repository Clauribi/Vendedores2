package com.example.demo.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Coche {
    @NotNull(message = "Marca is null")
    @NotBlank(message = "Marca is empty")
    protected String marca;
    @NotNull(message = "Modelo is null")
    @NotBlank(message = "Modelo is empty")
    protected String modelo;
    @NotNull(message = "Matricula is null")
    @NotBlank(message = "Matricula is empty")
    private String matricula;
    protected EstadoCoche estado;

    public Coche(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.estado = EstadoCoche.libre;
    }
    public Coche(){

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public EstadoCoche getEstado() {
        return estado;
    }

    public void setEstado(EstadoCoche estado) {
        this.estado = estado;
    }

}
