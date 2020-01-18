package edu.upc.dsa.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class User implements Comparable<User> {

    private String iduser;
    private String nickname;
    private String name;
    private String password;
    private boolean conectado;
    private int monedas;
    private int renos;

    public User(String nickname, String name, String password){
        this.setIduser();
        this.setNickname(nickname);
        this.setPassword(password);
        this.conectado= false;
    }

    public User(){
    }

    //GETTER & SETTER

    //De esta forma no hay que editar el id
    public void setIduser(){
        String iduser = UUID.randomUUID().toString();
        this.iduser=iduser;
    }

    public String getName() {
        return name;
    }

    public int getRenos() {
        return renos;
    }

    public void setRenos(int renos) {
        this.renos = renos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIduser() {
        return iduser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String pass){
        this.password=pass;
    }

    public String getPassword(){
        return this.password;
    }

    public void setMonedas(int monedas){
        this.monedas = monedas;
    }

    public int getMonedas(){
        return this.monedas;
    }

    public String getInfo(){
        return ("["+this.iduser+", "+this.nickname+"]");
    }


    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    @Override
    public int compareTo(User u) {
        return this.nickname.compareTo(u.nickname);
    }

    public String toString(){
        return this.nickname;
    }



}
