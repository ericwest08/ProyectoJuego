package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.util.*;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }



    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 1;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }



    public void close() {

    }

    public Object get(Class theClass, String ID) throws SQLException {
        Object entity = null;
        String selectQuery = QueryHelper.createQuerySELECT(theClass);
        ResultSet rs;
        PreparedStatement pstm;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, ID);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Field[] fields = theClass.getDeclaredFields();
                rs.getString(1);
                for (int i = 0; i < fields.length; i++) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    String fieldName = rsmd.getColumnName(i + 2);
                    ObjectHelper.setter(entity, fieldName, rs.getObject(i + 2));
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return entity;
    }
        public void update(Object entity, String ID) {
            String updateQuery = QueryHelper.createQueryUPDATE(entity);

            PreparedStatement pstm;

            try {
                pstm = conn.prepareStatement(updateQuery);
                int i = 1;

                for (String field : ObjectHelper.getFields(entity)) {
                        pstm.setObject(i++, ObjectHelper.getter(entity, field));
                    }


                pstm.setObject(i, ID);

                pstm.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }



    public void delete(Object object, String ID) {
        String deleteQuery = QueryHelper.createQueryDELETE(object);

        PreparedStatement pstm;

        try {
            pstm = conn.prepareStatement(deleteQuery);
            pstm.setObject(1, ID);

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getID(Class theClass, String username, String password) throws UserNotFoundException {
        String selectQuery = QueryHelper.createQueryIDUSER(theClass);

        ResultSet rs;
        PreparedStatement pstm;

        String id;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, username);
            pstm.setObject(2, password);
            rs = pstm.executeQuery();

            rs.next();

            id = rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserNotFoundException();
        }

        return id;
    }

    public boolean existeUsuario(Class theClass, String username, String password){
        String selectQuery = QueryHelper.createQueryEXISTEUSER(theClass);

        ResultSet rs;
        PreparedStatement pstm;

        boolean empty = true;
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, username);
            rs = pstm.executeQuery();

            while(rs.next()) {
                empty = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(empty == true)
            return false;
        else
            return true;
    }


    /*public List<Object> findAll(Class theClass) {
        return null;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }*/
}
