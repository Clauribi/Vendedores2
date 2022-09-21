package com.example.demo.domain;

public class NoExisteExcepcion extends Exception {
    public NoExisteExcepcion(String message) {
        super("**ERROR: NO EXISTE** " + message);
    }
}
