package edu.upc.dsa.models;

public abstract class Objeto implements Comparable<Objeto> {
    private String iduser;
    private String nameObject;
    private String descriptionObject;
    private int priceObject;

    public Objeto() {
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public String getDescriptionObject() {
        return descriptionObject;
    }

    public void setDescriptionObject(String descriptionObject) {
        this.descriptionObject = descriptionObject;
    }

    public int getPriceObject() {
        return priceObject;
    }

    public void setPriceObject(int priceObject) {
        this.priceObject = priceObject;
    }
    @Override
    public int compareTo(Objeto o) {
        return this.nameObject.compareTo(o.nameObject);
    }

    public String toString() {
        return this.nameObject;
    }
}
