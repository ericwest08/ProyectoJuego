package edu.upc.dsa;

import java.util.HashMap;
import java.util.List;

public interface GameManager {

    int size();
    void clear();
    void addUser(String iduser, String name, String surname);
    List<User> userlistordered();
    void modifyuser(String iduser, String name, String surname); //throws edu.upc.dsa.UserNotFoundException;
    int numUsers();
    User getinfouser (String iduser); //throws edu.upc.dsa.UserNotFoundException;
    void addObject(String userid, Objects o);
    List<Objects> objectsofuser (String iduser);//throws edu.upc.dsa.UserNotFoundException;
    int numObjects(String iduser) throws UserNotFoundException;
    HashMap<String, User> Usuarios();






}
