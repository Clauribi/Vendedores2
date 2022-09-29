package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Coche;
import com.example.demo.domain.EstadoReserva;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CocheUpdate {
    @NotNull(message = "Marca is null")
    @NotBlank(message = "Marca is empty")
    protected String marca;
    @NotNull(message = "Modelo is null")
    @NotBlank(message = "Modelo is empty")
    protected String modelo;
    protected EstadoReserva estado;
    protected Cliente cliente;

    public CocheUpdate(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.estado = EstadoReserva.libre;
    }
    public CocheUpdate(){

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

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Coche createDomainObject(String matricula) {
        return new Coche(this.marca, this.modelo, matricula);
    }
}
