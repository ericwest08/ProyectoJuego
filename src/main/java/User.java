import java.util.LinkedList;
import java.util.List;

import java.util.*;

public class User {

    LinkedList<Objects> objectlist;
    public String iduser;
    public String name;
    public String surname;

    public User(String iduser, String name, String surname){
        this.iduser = iduser;
        this.name = name;
        this.surname = surname;
        this.objectlist = new LinkedList<>();
    }

    public String toString(){
        return this.name;
    }
    public void setIduser(String id){
        this.iduser = id;
    }

    public String getIduser(){
        return this.iduser;
    }

    public void setNameuser(String name){
        this.name = name;
    }

    public String getNameuser(){
        return this.name;
    }

    public void setSurnameuser(String surname){
        this.surname = surname;
    }

    public String getSurnameuser(){
        return this.surname;
    }

    public void addObject (Objects o){
        this.objectlist.add(o);
    }

    public void setObjecttoUser(LinkedList<Objects> obj){
        this.objectlist=obj;
    }

    public LinkedList<Objects> getObjectttoUser(){return this.objectlist;}

    public int numUserObjects(String iduser){
        return objectlist.size();
    }



}
