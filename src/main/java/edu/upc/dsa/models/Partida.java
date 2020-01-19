package edu.upc.dsa.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.UUID;

public class Partida {
    private String nickname;
    private int tiempo;
    private int regalos;
    private int nivel;

    public Partida() {
        this.nivel = 0;
        tiempo=60;
    }


    public String getId() {
        return nickname;
    }

    public void setId(String nickname) {
        this.nickname =nickname;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getRegalos() {
        return regalos;
    }

    public void setRegalos(int regalos) {
        this.regalos = regalos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}