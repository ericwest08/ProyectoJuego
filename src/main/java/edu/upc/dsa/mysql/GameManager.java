package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Objects;
import edu.upc.dsa.models.User;

import java.util.HashMap;
import java.util.List;

public interface GameManager {

    int size();
    void clear();
    void addUser(String iduser, String name, String surname);
    List<User> userlistordered();
    void modifyuser(String iduser, String name, String surname); //throws edu.upc.dsa.exceptions.UserNotFoundException;
    int numUsers();
    User getinfouser (String iduser); //throws edu.upc.dsa.exceptions.UserNotFoundException;
    void addObject(String userid, Objects o);
    List<Objects> objectsofuser (String iduser);//throws edu.upc.dsa.exceptions.UserNotFoundException;
    int numObjects(String iduser) throws UserNotFoundException;
    HashMap<String, User> Usuarios();






}
