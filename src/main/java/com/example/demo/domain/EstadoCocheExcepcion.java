package com.example.demo.domain;

public class EstadoCocheExcepcion extends Exception{
    public EstadoCocheExcepcion(String message) {

        super("**ERROR: ** " + message);
    }

}
