package edu.upc.dsa.models;

public class Objects implements Comparable<Objects> {

    private String nameObject;
    private String descriptionObject;
    private int priceObject;
    private double peso;
    private int quantity;

    public Objects() {

    }

    public Objects(String nameObject, String descriptionObject, int price, double peso, int quantity ){
        this.nameObject=nameObject;
        this.descriptionObject=descriptionObject;
        this.priceObject = price;
        this.peso = peso;
        this.quantity=quantity;

    }

    public void setNameObject(String name){
        this.nameObject=name;
    }

    public String getNameObject(){
        return this.nameObject;
    }


    public void setQuantity(int q){
        this.quantity=q;
    }

    public int getQuantity(){
        return this.quantity;
    }

    @Override
    public int compareTo(Objects o) {
        return this.nameObject.compareTo(o.nameObject);
    }

    public String toString() {
        return this.nameObject;
    }

    public void numObjetos(int q){
        this.quantity+= q;
    }

    //@JsonIgnore
    //@ApiModelProperty(hidden = true)
    //public String getObjectid(){
        //return this.idObject;
    //}
}
