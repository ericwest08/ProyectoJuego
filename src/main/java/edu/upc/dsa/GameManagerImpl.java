package edu.upc.dsa;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;



public class GameManagerImpl implements GameManager{

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

    public GameManagerImpl() {// List<dsa.models.Product> productList, HashMap<String, dsa.models.edu.upc.dsa.User> users,Queue<dsa.models.Order> orderQueue) {
        this.objectsList = new LinkedList<>();
        this.users = new HashMap<>();

    }

    @Override
    public User getinfouser(String iduser) //throws edu.upc.dsa.UserNotFoundException
    {
        User user = this.users.get(iduser);
        //if(user != null){
            log.info("Info of user: " + user.getNameuser() + " " + user.getSurnameuser() + ". ");
            return users.get(iduser);
        //}
        //else{
            //log.error("The user doesn't exist");
            //throw new edu.upc.dsa.UserNotFoundException();
        //}

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
            //throw new edu.upc.dsa.UserNotFoundException();
        }


    @Override
    public void addUser(String iduser, String name, String surname) {
        User result=users.get(iduser);
        log.info(result);
        User aux;
        if (result==null)
        {
            aux=new User(iduser, name, surname);
            users.put(iduser,aux);
            log.info("edu.upc.dsa.User with name "+ aux.name+" id "+aux.iduser+ " and surname " + aux.surname +" has been added to the game");
        }
        else
        {
            log.warn("edu.upc.dsa.User with name, " + name + " already exists" );
        }

    }

    @Override
    public int numUsers() {
        log.info("Number of users: " +this.users.size());
        return this.users.size();
    }

    @Override
    public void addObject(String iduser, Objects o){
        User us =users.get(iduser);
        us.addObject(o);
        log.info(" The object " + us.getObjectttoUser() + " has been added to player " + us + ".");

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
















