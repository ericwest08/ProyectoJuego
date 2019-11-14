public class Objects {

    public String idObject;
    public String nameObject;
    public int priceObject;
    public int quantity;

    public Objects(String idObject, String nameObject, int priceObject){
        this.idObject=idObject;
        this.nameObject=nameObject;
        this.priceObject=priceObject;
    }
    public void setIdObject(String ido){
        this.idObject=ido;
    }

    public String getIdObject(){
        return this.idObject;
    }

    public void setNameObject(String name){
        this.nameObject=name;
    }

    public String getNameObject(){
        return this.nameObject;
    }

    public void setPriceObject(int p){
        this.priceObject=p;
    }

    public int getPriceObject(){
        return this.priceObject;
    }

    public void setQuantity(int q){
        this.quantity=q;
    }

    public int getQuantity(){
        return this.quantity;
    }

    //@JsonIgnore
    //@ApiModelProperty(hidden = true)
    //public String getObjectid(){
        //return this.idObject;
    //}
}
