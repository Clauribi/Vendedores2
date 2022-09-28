package com.example.demo.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concesionario {
    private HashMap<String, Vendedor> listadoVendedores = new HashMap<>();
    private HashMap<String, Cliente> listadoClientes = new HashMap<>();
    private HashMap<String, Coche> listadoCoches = new HashMap<>();

    public Concesionario(HashMap<String, Vendedor> listadoVendedores, HashMap<String, Cliente> listadoClientes, HashMap<String, Coche> listadoCoches) {
        this.listadoVendedores = listadoVendedores;
        this.listadoClientes = listadoClientes;
        this.listadoCoches = listadoCoches;
    }

    public Concesionario() {

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
        if (listadoVendedores.get(vendedor.getDni()) != null) {
            throw new ExisteExcepcion("el vendedor.");
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
            throw new NoExisteExcepcion("el vendedor.");
        } else {
            this.listadoVendedores.put(vendedor.getDni(), vendedor);
        }
    }

    public List<Vendedor> getAllVendedores() {
        return new ArrayList<>(listadoVendedores.values());
    }

    //CLIENTES
    public void addCliente(Cliente cliente) throws ExisteExcepcion {
        if (listadoClientes.get(cliente.getDni()) != null) {
            throw new ExisteExcepcion("el cliente.");
        } else {
            this.listadoClientes.put(cliente.getDni(), cliente);
        }
    }

    public List<Cliente> getAllClientes() {
        return new ArrayList<>(listadoClientes.values());
    }

    public void existeCliente(String dni) throws NoExisteExcepcion {
        if (!listadoClientes.containsKey(dni)) throw new NoExisteExcepcion("No existe el cliente.");
    }

    //COCHES
    public void addCoche(Coche coche) throws ExisteExcepcion {
        if (listadoCoches.get(coche.getMatricula()) != null) {
            throw new ExisteExcepcion("el coche.");
        } else {
            this.listadoCoches.put(coche.getMatricula(), coche);
        }
    }

    public List<Coche> getAllCoches() {
        return new ArrayList<>(listadoCoches.values());
    }

    public void existeCoche(String matricula) throws NoExisteExcepcion {
        if (!listadoCoches.containsKey(matricula))
            throw new NoExisteExcepcion("No existe el coche.");
    }

    //RESERVAS
    public void reservarCoche(String matricula) throws EstadoCocheExcepcion, NoExisteExcepcion {
        Coche coche = listadoCoches.get(matricula);
        if (coche != null) {
            if (coche.getEstado() == EstadoCoche.libre) {
                coche.setEstado(EstadoCoche.reservado);
            } else {
                throw new EstadoCocheExcepcion("El coche no se puede reservar porque el estado es " + coche.getEstado());
            }
        } else throw new NoExisteExcepcion("no existe el coche o/y el cliente");
    }


    public void cancelarReserva(String matricula) throws EstadoCocheExcepcion {
        Coche coche = listadoCoches.get(matricula);
        if (coche.getEstado() == EstadoCoche.reservado) {
            coche.setEstado(EstadoCoche.libre);
        } else {
            throw new EstadoCocheExcepcion("No se puede cancelar la reserva del coche porque el estado es: " + coche.getEstado());
        }
    }
}
