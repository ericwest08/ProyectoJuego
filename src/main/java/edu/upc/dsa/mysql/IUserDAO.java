package edu.upc.dsa.mysql;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;

import java.util.List;
import java.util.Stack;

public interface IUserDAO {

    String addUser(String nickname, String name, String password);
    User getUser(String nickname);
    void updateUser(String nickname, int monedas, int renos);
    void deleteUser(String nickname);
    User getInfo(Partida partida);
    Stack<Partida> partidasActivas();
    void cargarPartida(Partida partida);
    void guardarPartida(Partida partida);
    Partida nuevaPartida();
    Jugador comprarObjeto();
    //List<User> getUsers();
    //public List <User> getEmployeeByDept(int deptId);
}
