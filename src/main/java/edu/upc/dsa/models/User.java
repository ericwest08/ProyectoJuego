package edu.upc.dsa.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class User implements Comparable<User> {


    private String iduser = RandomStringUtils.randomAlphabetic(23);
    public String name;
    private String nickname;
    private String password;
    private boolean conectado;
    private int monedas;
    private Stack<Partida> partidas;
    private List<Objects> objectlist;
    private Jugador jugador;


    public User (String idnt, String name, String nick, String pass, boolean conectado, int monedas){
        this.iduser = idnt;
        this.name=name;
        this.nickname=nick;
        this.password=pass;
        this.monedas = monedas;
        this.conectado = conectado;
        //this.partidas = new Stack<>();
    }

    public User(String nickname, String password){
        this.setNickname(nickname);
        this.setPassword(password);
    }

    public User(){
    }

    public boolean checkPassword(String u, String p) {
        User aux = new User(u, p);
        if u.equals(this.(getNickname())
        if((thi.equals(accounts[0][0])) && (password.equals(accounts[0][1])))
            return true;
        else
            return false;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getInfo(){
        return ("["+this.iduser+", "+this.name+", "+this.nickname+"]");
    }

    public void setNameuser(String name){
        this.name = name;
    }

    public String getNameuser(){
        return this.name;
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

    public void addObject (Objects o){
        this.objectlist.add(o);
    }

    public void setObjecttoUser(List<Objects> obj){
        this.objectlist=obj;
    }

    public List<Objects> getObjectttoUser(){return objectlist;}

    public boolean getConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    //public int DameNumeroPartidas(){
        //return this.partidas.size();
    //}

    @Override
    public int compareTo(User u) {
        return this.name.compareTo(u.name);
    }

    public String toString(){
        return this.name;
    }



}
