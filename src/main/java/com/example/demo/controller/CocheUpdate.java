package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Coche;
import com.example.demo.domain.EstadoCoche;

public class CocheUpdate {
    protected String marca;
    protected String modelo;
    protected EstadoCoche estado;
    protected Cliente cliente;

    public CocheUpdate(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.estado = EstadoCoche.libre;
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

    public EstadoCoche getEstado() {
        return estado;
    }

    public void setEstado(EstadoCoche estado) {
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
