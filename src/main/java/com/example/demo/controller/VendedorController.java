package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class VendedorController {

    @PostMapping("/vendedores")
    public void altaVendedores(@Valid @RequestBody VendedorInput vendedor) {

    }

}
