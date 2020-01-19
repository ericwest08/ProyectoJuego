package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GmeMngImpl implements GameManager {
    final static Logger log = Logger.getLogger(GmeMngImpl.class.getName());


    public List<Objects> objectsOfUser(String nickname) {
        List<Objects> list = new LinkedList<>();
        
        list.addAll(objectsList);
        return list;
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
        return null;
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
    public Objects comprarObjeto() {
        return null;
    }

    @Override
    public void venderObjeto() {

    }

    @Override
    public void clear() {

    }

    @Override
    public HashMap<String, User> Usuarios() {
        return null;
    }
}
