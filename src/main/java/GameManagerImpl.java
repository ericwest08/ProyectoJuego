import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class GameManagerImpl implements GameManager{

    private Logger log = LogManager.getLogger(GameManagerImpl.class);
    private LinkedList<Objects> objectsList;
    private HashMap<String, User> users;
    private LinkedList<User> usersordered;

    private static GameManagerImpl instance = new GameManagerImpl();

    public static GameManagerImpl getInstance()
    {
        if(instance==null)
        {
            instance = new GameManagerImpl();
        }
        return instance;
    }

    public GameManagerImpl() {// List<dsa.models.Product> productList, HashMap<String, dsa.models.User> users,Queue<dsa.models.Order> orderQueue) {
        this.objectsList = new LinkedList<>();
        this.users = new HashMap<>();
        this.usersordered = new LinkedList<>();

    }

    @Override
    public int size(){
        int aux=this.objectsList.size();
        return aux;
    }

    @Override
    public void addUser(String iduser, String name, String surname){
        User result=users.get(iduser);
        log.info(result);
        User aux;
        if (result==null)
        {
            aux=new User(name, iduser, surname);
            users.put(iduser,aux);
            log.info("The user "+ aux.name+" with id '"+aux.iduser+ " and surname'" + aux.surname +" has been added to the system");
        }
        else
        {
            log.warn("The user " + name + " already exists" );
        }

    }

    @Override
    public int numUsers() {
        log.info("Number of users: " +this.users.size());
        return this.users.size();
    }

    @Override
    public void addObject(String idObject, String nameObject, int priceObject){

        User user;
        Objects result=objectsList.getFirst();
        log.info(result);
        Objects aux;
        if (result==null)
        {
            aux=new Objects(idObject, nameObject, priceObject);
            user.addObject(aux);
            log.info("The Object "+ aux.nameObject+" with id '"+aux.idObject+ " and price'" + aux. +" has been added to the user'" + user.getIduser() + ".");
        }
        else
        {
            log.warn("The Object " + idObject + " has been introduced before )";
        }


    }
    public int numObjects(String iduser){
        User user = users.get(iduser);
        log.info(user);
        int numobjects = user.numUserObjects(iduser);

        log.info("The number of objects of the player'" + iduser + " is '" + numobjects + ".");
    }

    












}
