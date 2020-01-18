package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public interface GameManager {

    /*Metodos relativos a la gestion de usuarios
    */
    void addUser(String nickname,String name, String password);
    void deleteUser(User user) throws UserNotFoundException;
    void updateUser(User u) throws UserNotFoundException;
    void cambiarcontraseña(String nickname, String newpassword) throws UserNotFoundException;
    List<User> userlistordered();
    int numUsers();
    User getInfo(String nickname) throws UserNotFoundException;
    void signin();
    User login();

    //Relativos a la partida
    Stack<Partida> partidasActivas();
    void cargarPartida(Partida partida);
    void guardarPartida(Partida partida);
    Partida nuevaPartida();

    //Metodos de la tienda
    Jugador comprarObjeto();
    void venderObjeto();
    void clear();


    HashMap<String, User> Usuarios();






}
