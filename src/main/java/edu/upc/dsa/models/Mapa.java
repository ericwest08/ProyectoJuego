package edu.upc.dsa.models;

public class Mapa {
    private int posicionX;
    private int posicionY;
    private int anchoX;
    private int altoY;

    public Mapa(){
        this.setPosicionX(0);
        this.setPosicionY(0);
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getAnchoX() {
        return anchoX;
    }

    public void setAnchoX(int anchoX) {
        this.anchoX = anchoX;
    }

    public int getAltoY() {
        return altoY;
    }

    public void setAltoY(int altoY) {
        this.altoY = altoY;
    }
}
