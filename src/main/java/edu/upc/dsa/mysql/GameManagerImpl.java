package edu.upc.dsa.mysql;

import edu.upc.dsa.models.Objects;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;
import org.apache.log4j.*;
import java.util.*;



public class GameManagerImpl implements GameManager {

    private Logger log = LogManager.getLogger(GameManagerImpl.class);
    private List<Objects> objectsList;
    private HashMap<String, User> users;

    private static GameManagerImpl instance = new GameManagerImpl();
    public static GameManagerImpl getInstance()
    {
        if(instance==null)
        {
            instance = new GameManagerImpl();
        }
        return instance;
    }


    public GameManagerImpl() {// List<dsa.models.Product> productList, HashMap<String, dsa.models.edu.upc.dsa.models.User> users,Queue<dsa.models.Order> orderQueue) {
        this.objectsList = new LinkedList<>();
        this.users = new HashMap<>();

    }

    @Override
    public void login() {

    }

    @Override
    public User getinfouser(String iduser) //throws edu.upc.dsa.exceptions.UserNotFoundException
    {
        User user = this.users.get(iduser);
        //if(user != null){
            log.info("Info of user: " + user.getNameuser() + " " + user.getSurnameuser() + ". ");
            return users.get(iduser);
        //}
        //else{
            //log.error("The user doesn't exist");
            //throw new edu.upc.dsa.exceptions.UserNotFoundException();
        //}

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
    public void borrarObjeto() {

    }

    @Override
    public void clear(){
        instance = null;
        this.objectsList.clear();
        users.clear();
    }

    @Override
    public int size(){
        int aux=this.objectsList.size();
        return aux;
    }

    @Override
    public void modifyuser(String iduser, String name, String surname){
        User user = this.users.get(iduser);
        //if(user != null){
        this.users.remove(iduser);
        user.setNameuser(name);
        user.setSurnameuser(surname);
        this.users.put(iduser, user);

        log.info("You have changed the dates of the user with id " + user.getIduser() + " to " + user.getNameuser() + " and " + user.getSurnameuser());
        //}
        //else{
            //log.error("The user doesn't exist");
            //throw new edu.upc.dsa.exceptions.UserNotFoundException();
        }


    @Override
    public void addUser(String name, String surname) {
        User result=users.get(name);
        log.info(result);
        User aux;
        if (result==null)
        {
            aux=new User(iduser, name, surname);
            users.put(iduser,aux);
            log.info("edu.upc.dsa.models.User with name "+ aux.name+" id "+aux.iduser+ " and surname " + aux.surname +" has been added to the game");
        }
        else
        {
            log.warn("edu.upc.dsa.models.User with name, " + name + " already exists" );
        }

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public int numUsers() {
        log.info("Number of users: " +this.users.size());
        return this.users.size();
    }

    @Override
    public void modifyuser(String name, String surname) {

    }

    @Override
    public User getInfo(String nickname) {
        return null;
    }

    @Override
    public void addObject(String iduser, edu.upc.dsa.models.Objects o){
        User us =users.get(iduser);
        us.addObject(o);
        log.info(" The object " + us.getObjectttoUser() + " has been added to player " + us + ".");

        }

    @Override
    public List<Objects> objectsOfUser(String iduser) {
        return null;
    }

    @Override
    public int numObjects(String iduser){
        User user = users.get(iduser);
        log.info("The user with id " + iduser + " have " + user.getObjectttoUser().size() + " objects.");
        return user.getObjectttoUser().size();

    }

    @Override
    public List<Objects> objectsofuser(String idus){
        User aux=users.get(idus);
        log.info("The user with id " + idus + " have " + aux.getObjectttoUser() + ".");
        return aux.getObjectttoUser();

    }

    @Override
    public HashMap<String, User> Usuarios() {
        return this.users;
    }

    @Override
    public List<User> userlistordered(){
        List<User> userList = new LinkedList<User>(this.Usuarios().values());
        Collections.sort(userList);
        log.info(userList);
        return userList;

    }

}
















