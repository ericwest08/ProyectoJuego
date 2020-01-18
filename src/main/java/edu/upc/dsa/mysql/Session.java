package edu.upc.dsa.mysql;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity);
    void close();
    Object get(Class theClass, String ID) throws SQLException;
    void update(Object object, String ID);
    void delete(Object object, String ID);
    /*List<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);*/
}
