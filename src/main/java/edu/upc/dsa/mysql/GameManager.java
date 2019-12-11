package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Objects;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public interface GameManager {

    //Metodos relativos a la gestion de usuarios
    void addUser(String name, String surname);
    void deleteUser(User user);
    List<User> userlistordered();
    int numUsers();
    void modifyuser(String name, String surname); //throws edu.upc.dsa.exceptions.UserNotFoundException;
    User getinfouser (String iduser); //throws edu.upc.dsa.exceptions.UserNotFoundException;
    void login();

    //Relativos a la partida
    Stack<Partida> partidasActivas();
    void cargarPartida(Partida partida);
    void guardarPartida(Partida partida);
    Partida nuevaPartida();

    //Metodos de la tienda
    Objects comprarObjeto();
    void venderObjeto();

    //Metodos de la relacion objetos-usuario
    void borrarObjeto();
    int size();
    void addObject(String userid, Objects o);
    List<Objects> objectsOfUser (String iduser);//throws edu.upc.dsa.exceptions.UserNotFoundException;
    int numObjects(String iduser) throws UserNotFoundException;

    void clear();


    HashMap<String, User> Usuarios();






}
