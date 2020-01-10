package edu.upc.dsa.mysql;

import edu.upc.dsa.models.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.util.List;

public class UserDAOImpl implements IUserDAO {
    final static Logger log = Logger.getLogger(UserDAOImpl.class.getName());


    public void loginUser(String login, String passwd){
        Session session = null;
        try{
            User user = new User();
            user.setNameuser(login);
            user.setPassword(passwd);

            session = FactorySession.openSession();
            session.selectlogin(user);
        }catch (Exception e) {
            log.error("MYSQL Login fallado con "+User.class);
        }
        finally {
            session.close();
        }
    }


    public String addUser(String nickname, String name, String password) {
        Session session = null;
        try {
            session = FactorySession.openSession();
            User user = new User(nickname, name, password);
            session.save(user);
        }
        catch (Exception e) {
            log.error("Error MSQL "+this.getClass());
        }
        finally {
            session.close();
        }

        return nickname;
    }


    public User getUser(String nickname) {
        Session session = null;
        User user = null;
        try {
            session = FactorySession.openSession();
            user = (User)session.get(User.class, nickname);
        }
        catch (Exception e) {
            log.error("Error MSQL "+this.getClass());
        }
        finally {
            session.close();
        }

        return user;
    }


    public void updateUser(String nickname, int monedas, int renos) {
        User user = this.getUser(nickname);
        user.setMonedas(monedas);
        Jugador jugador= user.getJugador();
        jugador.setRenos(renos);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(User.class);
        }
        catch (Exception e) {
            log.error("Error MSQL "+this.getClass());
        }
        finally {
            session.close();
        }
    }


    public void deleteUser(String nickname) {
        User user = this.getUser(nickname);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }

    public List<User> getUsers() {
        Session session = null;
        List<User> userList=null;
        try {
            session = FactorySession.openSession();
            userList = session.findAll(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return userList;
    }

    /*AQUI PODRÍA SER LO DE OBTENER POR NOMBRE ORDENANO
    public List<Employee> getEmployeeByDept(int deptID) {

        Session session = null;
        List<Employee> employeeList=null;
        try {
            session = FactorySession.openSession();

            HashMap<String, Integer> params = new HashMap<String, Integer>();
            params.put("deptID", deptID);

            employeeList = session.findAll(Employee.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return employeeList;
    }*/


}
