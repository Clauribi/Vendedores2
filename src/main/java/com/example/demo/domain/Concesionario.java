package com.example.demo.domain;

import com.example.demo.controller.VendedorInput;

import java.util.HashMap;

public class Concesionario {
    private HashMap<String, Vendedor> listadoVendedores;

    public Concesionario(HashMap<String, Vendedor> listadoVendedores) {
        this.listadoVendedores = new HashMap<>();
    }
    public Concesionario(){

    }

    public HashMap<String, Vendedor> getListadoVendedores() {
        return listadoVendedores;
    }

    public void setListadoVendedores(HashMap<String, Vendedor> listadoVendedores) {
        this.listadoVendedores = listadoVendedores;
    }

    public void noExisteVendedor(String dni) throws NoExisteExcepcion {
        if (!listadoVendedores.containsKey(dni)) throw new NoExisteExcepcion("No existe vendedor.");
    }
    public void altaVendedor (String nombre, String direccion, String dni, int telefono){
        Vendedor vendedorNew = new Vendedor(nombre, direccion, dni, telefono);
        this.listadoVendedores.put(dni, vendedorNew);
    }
}
