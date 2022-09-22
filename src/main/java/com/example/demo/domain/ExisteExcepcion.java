package com.example.demo.domain;

public class ExisteExcepcion extends Exception {
    public ExisteExcepcion(String message) {

        super("**ERROR: YA EXISTE** " + message);
    }
}

