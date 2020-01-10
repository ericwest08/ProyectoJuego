package edu.upc.dsa.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class User implements Comparable<User> {

    private String iduser;
    private String nickname;
    private String password;
    private Jugador jugador;
    private Stack<Partida> partidas;
    private int monedas;

    public User(String nickname, String password){
        this.setIduser();
        this.setNickname(nickname);
        this.setPassword(password);
        new Jugador();
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

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public int compareTo(User u) {
        return this.nickname.compareTo(u.nickname);
    }

    public String toString(){
        return this.nickname;
    }



}
