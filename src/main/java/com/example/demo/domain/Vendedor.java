package com.example.demo.domain;



public class Vendedor extends Persona{
    public Vendedor(String nombre, String direccion, String dni, String telefono) {
        super(nombre, direccion, dni, telefono);
    }

    public Vendedor() {
    }

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

    public void vendedorUpdate(String nombre, String direccion, String telefono) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
    }
}
