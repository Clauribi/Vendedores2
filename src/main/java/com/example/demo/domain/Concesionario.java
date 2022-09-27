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
    public HashMap<String, Coche> getListadoCoches() {
        return listadoCoches;
    }

    //VENDEDORES
    public void addVendedor(Vendedor vendedor) throws ExisteExcepcion {
        if(listadoVendedores.get(vendedor.getDni()) != null){
            throw new ExisteExcepcion("vendedor");
        } else {
            this.listadoVendedores.put(vendedor.getDni(), vendedor);
        }
    }

    public void deleteVendedor(String dni) throws NoExisteExcepcion {
        if (!listadoVendedores.containsKey(dni)) {
            throw new NoExisteExcepcion("el vendedor con dni: " + dni);
        } else {
            this.listadoVendedores.remove(dni);
        }
    }

    public void updateVendedor(Vendedor vendedor) throws NoExisteExcepcion {
        if (!listadoVendedores.containsKey(vendedor.getDni())) {
            throw new NoExisteExcepcion("el vendedor con dni: " + vendedor.getDni());
        } else {
            this.listadoVendedores.put(vendedor.getDni(), vendedor);
        }

    }
    //CLIENTES
    public void altaCliente(String nombre, String direccion, String dni, String telefono) {
        Cliente clienteNew = new Cliente(nombre, direccion, dni, telefono);
        this.listadoClientes.put(dni, clienteNew);
    }
    public void existeCliente(String dni) throws NoExisteExcepcion {
        if (!listadoClientes.containsKey(dni)) throw new NoExisteExcepcion("No existe el cliente.");
    }
    //COCHES
    public void altaCoche(String marca, String modelo, String matricula) {
        Coche cocheNew = new Coche(marca, modelo, matricula);
        this.listadoCoches.put(matricula, cocheNew);
    }
    public void existeCoche(String matricula) throws NoExisteExcepcion {
        if (!listadoCoches.containsKey(matricula))
            throw new NoExisteExcepcion("No existe el coche.");
    }
    //RESERVAS
    public void reservarCoche(Coche coche, Cliente cliente) throws EstadoCocheExcepcion {
        if (coche.getEstado() == EstadoCoche.libre) {
            coche.setEstado(EstadoCoche.reservado);
            cliente.agregarCocheReservado(coche);
            coche.setCliente(cliente);
        } else {
            throw new EstadoCocheExcepcion("El coche no se puede reservar porque el estado es " + coche.getEstado());
        }
    }
    public void cancelarReserva(Coche coche) throws EstadoCocheExcepcion {
        if (coche.getEstado() == EstadoCoche.reservado) {
            coche.setEstado(EstadoCoche.libre);
        } else {
            throw new EstadoCocheExcepcion("No se puede cancelar la reserva del coche porque el estado es: " + coche.getEstado());
        }
    }
}
