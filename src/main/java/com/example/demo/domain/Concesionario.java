package com.example.demo.domain;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class Concesionario {
    @NotNull(message = "listadoVendedores is null")
    private HashMap<String, Vendedor> listadoVendedores;

    public Concesionario(HashMap<String, Vendedor> listadoVendedores) {

        this.listadoVendedores = new HashMap<>();
    }

    public HashMap<String, Vendedor> getListadoVendedores() {
        return listadoVendedores;
    }

    public void setListadoVendedores(HashMap<String, Vendedor> listadoVendedores) {
        this.listadoVendedores = listadoVendedores;
    }

    public void altaVendedor(String nombre, String direccion, String dni, String telefono) {
        Vendedor vendedorNew = new Vendedor(nombre, direccion, dni, telefono);
        this.listadoVendedores.put(dni, vendedorNew);
    }

    public void bajaVendedor(String dni) {
        this.listadoVendedores.remove(dni);
    }

    public void modificarVendedor(String nombre, String direccion, String dni, String telefono) {
        Vendedor vendedor = listadoVendedores.get(dni);
        vendedor.vendedorUpdate(nombre, direccion, telefono);
        this.listadoVendedores.put(dni, vendedor);

    }
}
