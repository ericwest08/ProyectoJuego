package edu.upc.dsa.mysql;

import edu.upc.dsa.models.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Stack;

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
            session.update(User.class, user.getIduser());
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
            session.delete(User.class, user.getIduser());
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }

    public void actualizarcontraseña(String nickname, String newpassword){

        User user = this.getUser(nickname);
        user.setPassword(newpassword);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(User.class, user.getIduser());
        }
        catch (Exception e) {
            log.error("Error MSQL "+this.getClass());
        }
        finally {
            session.close();
        }

    }

   public Partida getInfo(String nickname){
        User user = null;
        Session session = null;
       try {
           session = FactorySession.openSession();
           user = (User)session.get(Partida.class,);
       }
       catch (Exception e) {
           log.error("Error MSQL "+this.getClass());
       }
       finally {
           session.close();
       }


   }

    public Stack<Partida> partidasActivas(){

    }

    public void cargarPartida(Partida partida){

    }
    public void guardarPartida(Partida partida){

    }
    public Partida nuevaPartida(){

    }
    public Jugador comprarObjeto(){

    }



    /*public List<User> getUsers() {
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
    }*/


}
