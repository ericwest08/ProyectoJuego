package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class User implements Comparable<User> {

    List<Objects> objectlist;
    public String iduser;
    public String name;
    public String surname;

    public User(String iduser, String name, String surname){
        this.iduser = iduser;
        this.name = name;
        this.surname = surname;
        this.objectlist = new LinkedList<>();
    }

    public User(){
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

    public void setObjecttoUser(List<Objects> obj){
        this.objectlist=obj;
    }

    public List<Objects> getObjectttoUser(){return objectlist;}


    @Override
    public int compareTo(User u) {
        return this.name.compareTo(u.name);
    }

    public String toString(){
        return this.name;
    }



}
