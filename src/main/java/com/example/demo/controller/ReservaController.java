package com.example.demo.controller;

import com.example.demo.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservaController {
    private Concesionario concesionario = new Concesionario();
    Coche coche = null;
    Cliente cliente = null;


    @PostMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public void reservarCoche(@PathVariable String matricula, @PathVariable String dni)  {
      /*  try {
            concesionario.existeCoche(matricula);
            concesionario.existeCliente(dni);
        } catch (NoExisteExcepcion e) {
            e.getMessage();
        }*/
        try {
            coche = concesionario.getListadoCoches().get(matricula);
            cliente = concesionario.getListadoClientes().get(dni);
            concesionario.reservarCoche(coche, cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public void cancelarReserva(@PathVariable String matricula, @PathVariable String dni) {
        try {
            coche = concesionario.getListadoCoches().get(matricula);
            cliente = concesionario.getListadoClientes().get(dni);
            concesionario.cancelarReserva(coche);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

