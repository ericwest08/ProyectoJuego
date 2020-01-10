package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.excluded.Objects;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public interface GameManager {

    /*Metodos relativos a la gestion de usuarios
    */
    void addUser(String nickname, String name, String password);
    void deleteUser(User user) throws UserNotFoundException;
    void updateUser(User user) throws UserNotFoundException;     //Si queremos cambiar algun valor del usuario
    void updateUser(User user, Objects obj, int i) throws UserNotFoundException; //Puede añadir o quitar un objeto a un usuario(si lo vendmos?)

    List<Objects> objectsOfUser (String nickname);//throws edu.upc.dsa.exceptions.UserNotFoundException;
    List<Objects> objectsOfUser (User user);//throws edu.upc.dsa.exceptions.UserNotFoundException;


    List<User> userlistordered();
    int numUsers();
    User getInfo(String nickname); //throws edu.upc.dsa.exceptions.UserNotFoundException;

    void signin();

    //Relativos a la partida
    Stack<Partida> partidasActivas();
    void cargarPartida(Partida partida);
    void guardarPartida(Partida partida);
    Partida nuevaPartida();

    //Metodos de la tienda
    Objects comprarObjeto();
    void venderObjeto();

    void clear();


    HashMap<String, User> Usuarios();






}
