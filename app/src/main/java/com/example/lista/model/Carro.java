package com.example.lista.model;

import android.app.Dialog;

import java.io.Serializable;

public class Carro implements Serializable {


    private Long id;
    private String nomeCarro;
    private int modeloCar;
    private String marca;
    private String ano;
    private String preco;
    private String Local;
    private boolean Disponivel;

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


    public Carro ( String nomeCarro, int modeloCar){
      //  id = id;
        this.nomeCarro = nomeCarro;
        this.modeloCar = modeloCar;
    }

    public Carro(String marca, String nomeCarro, String ano, int modeloCar,
                 boolean Disponivel, String preco, String Local) {
        this.marca = marca;
        this.nomeCarro = nomeCarro;
        this.ano = ano;
        this.modeloCar = modeloCar;
        //this.Kilometragem = Kilometragem;
        this.Disponivel = Disponivel;
        // this.Proprietario = Proprietario;
        this.preco = preco;
        this.Local = Local;
    }
}
