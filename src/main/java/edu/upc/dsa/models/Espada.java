package edu.upc.dsa.models;

public class Espada extends Objects {

    private String name;
    private String descripcion;
    private int peso;
    private int daño;
    private int precio;
    private boolean estado;
    private Jugador jugador;

    public Espada(String name, String descripcion, int peso, int daño, int precio, boolean estado){

        this.name = name;
        this.descripcion = descripcion;
        this.peso = peso;
        this.daño = daño;
        this.precio = precio;
        this.estado = false;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public double getPeso(){
        return this.peso;
    }

    public void setDaño(int daño){
        this.daño = daño;
    }

    public int getDaño(){
        return this.daño;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return this.precio;
    }

    public String useObject() {
        String res;
        if (estado == false) {
            this.jugador.setDaño(jugador.getDaño() + this.daño);
            res = "Tu ataque ha incrementado " + this.daño + " puntos.";
            estado = true;
        }

        else {

            res = "Ya estas utilizando la espada";

        }

        return res;
    }
}
