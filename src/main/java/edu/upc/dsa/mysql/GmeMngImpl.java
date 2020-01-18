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


    //Habría que mirar como está mirando en el mapa cada valor, pero es secundario
    public void addUser(String nickname, String name, String password) {
        User user0 = new User(nickname, name, password);
        User result = users.get(user0);
        if (result == null) {
            users.put(user0.getIduser(), user0);
            UserDAOImpl user1 = new UserDAOImpl();
            user1.addUser(nickname, name, password);

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

    public void updateUser(User u) throws UserNotFoundException {
        User theUser = this.users.get(u);
        if (theUser != null) {
            this.users.remove(u.getIduser());
            log.info("Actualizado: " + theUser);
            this.users.put(u.getIduser(), u);
            new UserDAOImpl().updateUser(u.getNickname(), u.getMonedas(), u.getObjectttoUser());
        } else {
            log.warn("El usuario no existe");
            throw new UserNotFoundException();
        }

    }

    public void updateUser(User user, Objects obj, int i) throws UserNotFoundException {
        User theUser = this.users.get(user);
        if (theUser != null) {
            this.users.remove(user.getIduser());
            List<Objects> listaAuxObjects = theUser.getObjectttoUser();

            for (Objects objetoAux : listaAuxObjects) {
                if (objetoAux.getNameObject().equals(obj.getNameObject())) {
                    i = i + objetoAux.getQuantity();
                    listaAuxObjects.remove(objetoAux);
                }
            }
            obj.setQuantity(i);
            theUser.addObject(obj);
            //Esto haría lo mismo
            //listaAuxObjects.add(obj);
            //theUser.setObjecttoUser(listaAuxObjects);
            this.users.put(theUser.getIduser(), theUser);
            log.info("Actualizado: " + theUser);
            updateUser(theUser);
        } else {
            log.warn("El usuario no existe");
            throw new UserNotFoundException();
        }
    }

    public List<Objects> objectsOfUser(String nickname) {
        List<Objects> list = new LinkedList<>();
        
        list.addAll(objectsList);
        return list;
    }

    @Override
    public List<Objects> objectsOfUser(User user) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return customer;
            }
        }
    }

    @Override
    public List<User> userlistordered() {
        return null;
    }

    @Override
    public int numUsers() {
        return 0;
    }

    @Override
    public User getInfo(String nickname) {
        return null;
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
