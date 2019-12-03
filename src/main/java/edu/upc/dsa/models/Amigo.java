package edu.upc.dsa.models;

public class Amigo {

    private String text;
    private Objects o;

    public Amigo(String t, Objects o){
        this.text = t;
        this.o = o;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    public void addObject(Objects o){
        this.o = o;
    }

}
