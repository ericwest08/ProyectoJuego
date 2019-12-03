package edu.upc.dsa.models;

public class Pocion extends Objects{
    private String name;
    private String descripcion;
    private int peso;
    private int cura;
    private int precio;
    private int cantidad;
    private Jugador jugador;

    public Pocion(String name, String descripcion, int peso, int cura, int precio, int cantidad){

        this.name = name;
        this.descripcion = descripcion;
        this.peso = peso;
        this.cura = cura;
        this.precio = precio;
        this.cantidad = cantidad;
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

    public void setCura(int cura){
        this.cura = cura;
    }

    public int getCura(){
        return this.cura;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return this.precio;
    }

    public String useObject() {
        String res;
        if (this.cantidad>=1) {
            if (this.jugador.getVida() + this.cura > 100){
                this.jugador.setVida(100);
                this.cantidad--;
            }
            else {
                this.jugador.setVida(this.jugador.getVida() + this.cura);
                this.cantidad--;
            }

            res = "Tu vida ha incrementado " + this.cura + " puntos.";
        }

        else {

            res = "No te quedan pociones";
        }

        return res;
    }


}
