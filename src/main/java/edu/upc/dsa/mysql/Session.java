package edu.upc.dsa.mysql;

import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity);
    boolean selectlogin(Object entity);
    void close();
    Object get(Class theClass, String ID);
    void update(Object object);
    void delete(Object object);
    List<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
}
