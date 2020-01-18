package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.excluded.Objects;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GmeMngImpl implements GameManager {

    final static Logger log = Logger.getLogger(GmeMngImpl.class.getName());

    private Stack<Partida> partidasActivas;
    private HashMap<String, User> users;
    private Partida partida;
    private Jugador jugador;

    public GmeMngImpl(){
        this.users = new HashMap<>();
        this.partida = new Partida();
        this.partidasActivas = new Stack<>();
    }

    //Habría que mirar como está mirando en el mapa cada valor, pero es secundario
    public void addUser(String nickname, String name, String password) {
        User user0 = new User(nickname, name, password);
        User result = users.get(user0);
        if (result == null) {
            users.put(user0.getIduser(), user0);
            UserDAOImpl user1 = new UserDAOImpl();
            user1.addUser(nickname,name,password);

            log.info("Añadido nuevo usuario: "+user0.getIduser());
        } else
            log.warn("The user " + user0.getNickname() + " ya existe");
    }

    public void deleteUser(User user) throws UserNotFoundException {
        try {
            User result = users.remove(user);
            new UserDAOImpl().deleteUser(user.getNickname());
            log.info("Usuario " + user.getNickname() + " borrado");
        }catch (Exception e){
            log.error("El usuario no existe");
        }
    }

    public void cambiarcontraseña(String nickname,String newpassword) throws UserNotFoundException{
        User theUser = this.users.get(nickname);

        if (theUser != null) {
            theUser.setPassword(newpassword);
            log.info("Actualizado: " + theUser + " con nueva contraseña: " + theUser.getPassword() + ".");
            new UserDAOImpl().actualizarcontraseña(nickname, newpassword);
        }
        else{
            log.warn("El usuario no existe");
            throw new UserNotFoundException();
        }

    }

    public void updateUser(User u) throws UserNotFoundException {
        User theUser = this.users.get(u);
        if (theUser != null) {
            this.users.remove(u.getIduser());
            log.info("Actualizado: " + theUser);
            this.users.put(u.getIduser(), u);
            new UserDAOImpl().updateUser(u.getNickname(), u.getMonedas(), jugador.getRenos());
        } else {
            log.warn("El usuario no existe");
            throw new UserNotFoundException();
        }

    }
    @Override
    public int numUsers() {
        return users.size();
    }

    @Override
    public List<User> userlistordered() {



    }



    @Override
    public Partida getInfo(String nickname){
        User theUser = users.get(nickname);

        if (theUser!=null)
        {
            theUser = new UserDAOImpl().getInfo(nickname);
            log.info("Datos usuario: " + theUser + ".");
        }
        else
        {
            log.warn("El usuario no existe");

        }

        return theUser;
    }

    @Override
    public void signin() {

    }

    @Override
    public Stack<Partida> partidasActivas() {

    }

    @Override
    public void cargarPartida(Partida partida) {

    }

    @Override
    public void guardarPartida(Partida partida) {

    }

    @Override
    public Partida nuevaPartida() {
        return null;
    }

    @Override
    public Jugador comprarObjeto() {
        return null;
    }


    @Override
    public void clear() {

    }

    @Override
    public HashMap<String, User> Usuarios() {
        return null;
    }
}
