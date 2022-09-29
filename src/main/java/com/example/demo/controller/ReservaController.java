package com.example.demo.controller;

import com.example.demo.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ReservaController {
    private Concesionario concesionario = new Concesionario();


    @PostMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public String hacerReserva(@PathVariable String matricula, @PathVariable String dni) {
        try {
            ArrayList<Reserva> listaReservas = new ArrayList<>();
            for (Reserva reserva : concesionario.getListadoReservas().values()) {
                listaReservas.add(reserva);
            } return listaReservas.toString();
            
        } catch (Exception e) {
            e.getMessage();
        } return null;
    }

    @DeleteMapping("/reservas/coche/{matricula/cliente/{dni}")
    public void cancelarReserva(@PathVariable String matricula, @PathVariable String dni) {
        try {
            concesionario.cancelarReserva(matricula);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

