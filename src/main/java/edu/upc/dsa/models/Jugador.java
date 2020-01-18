package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Jugador {
    private int renos;
    private int regalos;

    public Jugador() {
        this.renos=0;
    }


    public int getRenos() {
        return renos;
    }

    public void setRenos(int renos) {
        this.renos = renos;
    }

    public int getRegalos() {
        return regalos;
    }

    public void setRegalos(int regalos) {
        this.regalos = regalos;
    }
}