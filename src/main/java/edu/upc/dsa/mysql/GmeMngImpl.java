package edu.upc.dsa.mysql;

import edu.upc.dsa.models.Mapa;
import edu.upc.dsa.models.Objects;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class GmeMngImpl implements GameManager {
    final static Logger log = Logger.getLogger(GmeMngImpl.class.getName());

    private List<Objects> objectsList;
    private HashMap<String, User> users;
    private Mapa mapaJuego;
    private Partida partida;

    public GmeMngImpl(){
        this.users = new HashMap<>();
        this.mapaJuego = new Mapa();
        this.partida = new Partida();
        this.objectsList = null;
    }

    //Habría que mirar como está mirando en el mapa cada valor, pero es secundario
    //Tiene que llamar a un servicio DAO...
    public void addUser(String nickname, String name, String password) {
        User user0 = new User(nickname, name, password);
        User result = users.get(user0);
        if (result == null) {
            users.put(user0.getIduser(), user0);
            log.info("Añadido nuevo usuario "+users);
        } else
            log.warn("The user " + user0.getNickname() + " ya existe");
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void updateUser(User user, Object obj, int i) {

    }

    @Override
    public List<Objects> objectsOfUser(String nickname) {
        return null;
    }

    @Override
    public List<Objects> objectsOfUser(User user) {
        return null;
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
