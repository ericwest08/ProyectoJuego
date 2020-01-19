package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;

import java.util.List;

public interface IUserDAO {
    //Asociados a gestion der cuentas de usuario --- LOGIN
    Jugador loginUser(String login, String passwd) throws UserNotFoundException,UserAlreadyConnectedException;
    void addUser(String nickname, String name, String password);
    void cambiarPassword(String nickname ,String password, String newpass) throws UserNotFoundException;
    void deleteUser(String nickname) throws UserNotFoundException;
    void clear();
    int numUsers();
    //Relativos al juego --- GAME
    User getUser(String nickname);
    void updateUser(String nickname, int monedas, int renos);
    String getIduser(String nickname, String password) throws UserNotFoundException;
    Partida getInfo(String nickname);
    void comprarObjeto(String iduser, int cantidad) throws UserNotFoundException;
    void logout(String nickname, int nivel, int regalos, int renos) throws UserNotFoundException;
}
