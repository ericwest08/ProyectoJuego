package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Jugador {

    private String name;
    private int vida;
    private int daño;
    private int defensa;
    private int puntos;
    List<Objects> inventario;

    public Jugador(){

    }
    public Jugador(String name, int vida, int daño, int defensa, int puntos){
        this.name = name;
        this.vida = vida;
        this.daño = daño;
        this.defensa = defensa;
        this.puntos=puntos;
        this.inventario = new LinkedList<>();
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getVida(){
        return this.vida;
    }

    public void setDaño(int daño){
        this.daño = daño;
    }

    public int getDaño(){
        return this.daño;
    }

    public void setDefensa(int defensa){
        this.defensa = defensa;
    }

    public int getDefensa(){
        return this.defensa;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public int getPuntos(){
        return this.puntos;
    }

    public int DameNumeroObjetos(){
        return this.inventario.size();
    }

    public void addObject(Objects o){
        this.inventario.add(o);
    }

    public void deleteObject(Objects o){
        this.inventario.remove(o);
    }

    public void useObject(Objects o){
        //aquí usaremos el logger

    }
}
