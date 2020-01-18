package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserAlreadyConnectedException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.util.List;

public class UserDAOImpl implements IUserDAO {
    final static Logger log = Logger.getLogger(UserDAOImpl.class.getName());


    public void loginUser(String login, String passwd) throws UserNotFoundException, UserAlreadyConnectedException {
        Session session = null;
        User user=null;
        Jugador jugador = null;
        String idUser = getIduser(login, passwd);

        try{
            session = FactorySession.openSession();
            user = (User) session.get(User.class, idUser);
        }catch (Exception e) {
            log.error("MYSQL Login fallado con "+User.class);
        }
        finally {
            session.close();
        }
        if(!user.isConectado()){
            user.setConectado(true);

            try {
                session = FactorySession.openSession();
                session.update(user, idUser);
                jugador = (Jugador)session.get(Jugador.class, idUser);
            }
            catch (Exception e) {
                log.error("Error trying to open the session: " +e.getMessage());
                throw new UserNotFoundException();
            }
            finally {
                session.close();
            }
        }
        else{
            log.error("El usuario ya existe");
            throw new UserAlreadyConnectedException();
        }

    }


    public String addUser(String nickname, String name, String password) {
        Session session = null;
        try {
            session = FactorySession.openSession();
            User user = new User(nickname, name, password);
            session.save(user);
            String idUser = getIduser(nickname, password);
            Jugador jugador = new Jugador();
            jugador.setIduser(idUser);

            session.save(jugador);
            log.info("Jugador creado "+this.getClass().getSimpleName());
        }
        catch (Exception e) {
            log.error("Error MYSQL "+this.getClass());
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
        String idUser = user.getIduser();
        user.setMonedas(monedas);
        Session session = null;
        Jugador jugador = null;
        jugador.setRenos(renos);
        try {
            session = FactorySession.openSession();
            session.update(User.class, idUser)
            session.update(Jugador.class, idUser);
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

    public String getIduser(String nickname, String password) throws UserNotFoundException {
    String idUser;
    Session session = null;

    try {
        session = FactorySession.openSession();
        idUser = session.getID(User.class, nickname, password);
    } catch(Exception e){
        log.error("El usuario no existe"+ e.getMessage());
        throw new UserNotFoundException();
    return idUser;
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
