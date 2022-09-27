package com.example.demo.domain;

public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private EstadoCoche estado;
    private Cliente cliente;

    public Coche(String marca, String modelo, String matricula, EstadoCoche estado, Cliente cliente) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.estado = estado;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
