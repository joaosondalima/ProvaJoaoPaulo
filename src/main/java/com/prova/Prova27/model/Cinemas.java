package com.prova.Prova27.model;

public class Cinemas {

    private int idCinema;
    private String nome;
    private int qntSalas;

    public Cinemas(String nome, int qntSalas){
        this.setNome(nome);
        this.setQntSalas(qntSalas);
    }
    public Cinemas() {

    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQntSalas() {
        return qntSalas;
    }

    public void setQntSalas(int qntSalas) {
        this.qntSalas = qntSalas;
    }
}
