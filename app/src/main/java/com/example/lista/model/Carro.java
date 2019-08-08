package com.example.lista.model;

import java.io.Serializable;

public class Carro implements Serializable {

    private Long id;
    private String nomeCarro;
    private int modeloCar;

    public int getModeloCar() {
        return modeloCar;
    }

    public void setModeloCar(int modeloCar) {
        this.modeloCar = modeloCar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }
}
