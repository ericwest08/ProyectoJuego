package edu.upc.dsa.models;

public class Enemigo {

    private int vida;
    private String nombreObjeto;
    private int posicionx;
    private int posiciony;


    public Enemigo(int vida, String name, int posicionx, int posiciony){
        this.vida = vida;
        this.nombreObjeto=name;
        this.posicionx = posicionx;
        this.posiciony = posiciony;
    }

    public Enemigo(){

    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getVida(){
        return this.vida;
    }

    public void setPosicionx(int x){
        this.posicionx = x;
    }

    public int getPosicionx(){
        return this.posicionx;
    }

    public void setPosiciony(int y){
        this.posicionx = y;
    }

    public int getPosiciony(){
        return this.posiciony;
    }


    public void setNombreObjeto(String name){
        this.nombreObjeto = name;
    }

    public String getNombreObjeto(){
        return this.nombreObjeto;
    }



}
