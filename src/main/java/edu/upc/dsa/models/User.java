package edu.upc.dsa.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class User implements Comparable<User> {

    private String iduser;
    private String nickname;
    public String name;
    private String password;
    private Jugador jugador;    /*Si debemos dejar que haya mas de un jugador/partida por usuario
                                esto hay que cambiarlo, o hay que poner el atributo de jugador en partida*/

    private boolean conectado;
    private Stack<Partida> partidas;

    private List<Objects> objectlist;
    private int monedas;
    /*
    public User (String idnt, String name, String nick, String pass, boolean conectado, int monedas){
        this.iduser = idnt;
        this.name=name;
        this.nickname=nick;
        this.password=pass;
        this.monedas = monedas;
        this.conectado = conectado;
        //this.partidas = new Stack<>();
    }*/

    public User(String nickname, String name, String password){
        this.setIduser();
        this.setNickname(nickname);
        this.setNameuser(name);
        this.setPassword(password);
    }

    public User(){
    }

    //GETTER & SETTER

    //De esta forma no hay que editar el id
    public void setIduser(){
        String iduser = UUID.randomUUID().toString();
        this.iduser=iduser;
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

    public boolean getConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }


    public String getInfo(){
        return ("["+this.iduser+", "+this.name+", "+this.nickname+"]");
    }

    public void addObject (Objects o){
        this.objectlist.add(o);
    }

    //Hace falta deleteObject

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
