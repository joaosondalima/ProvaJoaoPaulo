package com.prova.Prova27.model;

public class Sessao {

    private int idSessao;
    private String film;
    private int numSala;

    public Sessao(String film, int numSala) {
        this.film = film;
        this.numSala = numSala;
    }
    public Sessao() {

    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

}
