package edu.upc.dsa.models;

public class Escudo extends Objects {

    private String name;
    private String descripcion;
    private int peso;
    private int defensa;
    private int precio;
    private boolean estado;
    private Jugador jugador;

    public Escudo(String name, String descripcion, int peso, int defensa, int precio, boolean estado){

        this.name = name;
        this.descripcion = descripcion;
        this.peso = peso;
        this.defensa = defensa;
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

    public void setDefensa(int defensa){
        this.defensa = defensa;
    }

    public int getDefensa(){
        return this.defensa;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return this.precio;
    }

    public String useObject() {
        String res;
        this.jugador.setDefensa(jugador.getDefensa() + this.defensa);
        if (estado == false) {
            res = "Tu defensa ha incrementado " + this.defensa + " puntos.";
            estado = true;
        }

        else {

            res = "Ya estas utilizando el escudo";

        }

        return res;
    }
}
