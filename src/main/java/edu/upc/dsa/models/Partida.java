package edu.upc.dsa.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Partida {
    private String id = RandomStringUtils.randomAlphanumeric(9);
    private int numeroMapa;
    private Mapa posicion;

    public Partida() {
        this.numeroMapa = 0;
        this.posicion = new Mapa();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumeroMapa() {
        return numeroMapa;
    }

    public void setNumeroMapa(int numeroMapa) {
        this.numeroMapa = numeroMapa;
    }

    public Mapa getPosicion() {
        return posicion;
    }

    public void setPosicion(Mapa posicion) {
        this.posicion = posicion;
    }
}

