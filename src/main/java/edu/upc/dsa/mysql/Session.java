package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity);
    void close();
    Object get(Class theClass, String ID) throws SQLException;
    String getID(Class theClass, String username, String password) throws UserNotFoundException;
    void update(Object object, String ID);
    void delete(Object object, String ID);
    boolean existeUsuario(Class theClass, String nickname, String password);
    /*List<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);*/
}
