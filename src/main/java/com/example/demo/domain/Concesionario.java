package com.example.demo.domain;
import java.util.HashMap;

public class Concesionario {
    private HashMap<String, Vendedor> listadoVendedores;
    private HashMap<String, Cliente> listadoClientes;
    private HashMap<String, Coche> listadoCoches;

    public Concesionario(HashMap<String, Vendedor> listadoVendedores, HashMap<String, Cliente> listadoClientes, HashMap<String, Coche> listadoCoches) {
        this.listadoVendedores = listadoVendedores;
        this.listadoClientes = listadoClientes;
        this.listadoCoches = listadoCoches;
    }
    public Concesionario(){

    }
    public HashMap<String, Vendedor> getListadoVendedores() {
        return listadoVendedores;
    }

    public HashMap<String, Cliente> getListadoClientes() {
        return listadoClientes;
    }
    public void existeCliente(String dni) throws NoExisteExcepcion {
        if (!listadoClientes.containsKey(dni)) throw new NoExisteExcepcion("No existe el cliente.");
    }

    public HashMap<String, Coche> getListadoCoches() {
        return listadoCoches;
    }
    public void existeCoche(String matricula) throws NoExisteExcepcion {
        if (!listadoCoches.containsKey(matricula))
            throw new NoExisteExcepcion("No existe el coche.");
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
