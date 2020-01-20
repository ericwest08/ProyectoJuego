package edu.upc.dsa.mysql;

import edu.upc.dsa.exceptions.UserAlreadyConnectedException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class UserDAOImpl implements IUserDAO {
    final static Logger log = Logger.getLogger(UserDAOImpl.class.getName());
    private static IUserDAO instance;
    private HashMap<String, User> users;
    private UserDAOImpl(){
    }
    public static IUserDAO getInstance() {
        if(instance==null){
            instance=new UserDAOImpl();
        }return instance;
    }

    public Jugador loginUser(String nickname, String passwd) throws UserNotFoundException, UserAlreadyConnectedException {
        Session session = null;

        User user=null;
        Jugador jugador;
        String iduser = getIduser(nickname, passwd);
        try{
            session = FactorySession.openSession();
            user = (User) session.get(User.class, iduser);
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
                session.update(user, iduser);
                jugador = (Jugador)session.get(Jugador.class, iduser);
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
            log.error("El usuario ya está conectado");
            throw new UserAlreadyConnectedException();
        }
    return jugador;
    }


    public void addUser(String nickname, String name, String password) {
        Session session = null;
        try {
            session = FactorySession.openSession();
            //String id = session.getID(User.class, nickname, password);
            //Hay que evitar que salte a la interrupcion si no encuentra a nadie
            if(!session.existeUsuario(User.class, nickname, password)) {

                User user = new User(nickname, name, password);
                session.save(user);
                String idUser = getIduser(nickname, password);
                Jugador jugador = new Jugador();
                jugador.setIduser(idUser);

                session.save(jugador);
                log.info("Jugador creado " + this.getClass().getSimpleName());
            }else throw new UserAlreadyConnectedException();
        }catch (Exception e) {
            log.error("Error MYSQL "+this.getClass());

        }
        finally {
            session.close();
        }
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

    @Override
    public void cambiarPassword(String nickname, String password, String newPass) throws UserNotFoundException {
        String idUser= getIduser(nickname, password);

        Session session = null;

        Login credentials = new Login();
        credentials.setNickname(nickname);
        credentials.setOldpassword(password);
        credentials.setNewpassword(newPass);
        try{
            session = FactorySession.openSession();
            User user= getUser(nickname);
            user.setPassword(newPass);
            session.update(user, idUser);
            log.info("Actualizado: " + user.getName() + " con nueva contraseña");
        }catch (Exception e) {
            log.error("El usuario no existe "+this.getClass());
            throw  new UserNotFoundException();
        }
        finally {
            session.close();
        }
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
            session.update(User.class, idUser);
            session.update(Jugador.class, idUser);
        }
        catch (Exception e) {
            log.error("Error MYSQL "+this.getClass());
        }
        finally {
            session.close();
        }
    }

    public int numUsers(){
        return this.users.size();
    }



    public void deleteUser(String nickname) throws UserNotFoundException {
        User user = this.getUser(nickname);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(User.class, user.getIduser());
        }
        catch (Exception e) {
            throw new UserNotFoundException();
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
        } catch (Exception e) {
            log.error("El usuario no existe" + e.getMessage());
            throw new UserNotFoundException();

        }finally {
            //hace falta cerrar la sesion para que no de error en el login
            session.close();
        }
        return idUser;
    }
    public Partida getInfo(String nickname){
        User user=getUser(nickname);
        Jugador jugador = getJugador(user.getIduser());
        Partida partida=new Partida();
        partida.setId(nickname);
        partida.setNivel(jugador.getRegalos());
        log.info("El usuario: "+user.getNickname());
        log.info("ha conseguido llegar al nivel "+partida.getNivel());
        return partida;
    }

    public void clear(){
        instance = null;
    }

    public void comprarObjeto(String iduser, int cantidad) throws UserNotFoundException{
        Jugador jugador= getJugador(iduser);
        User user =getUser(iduser);
        jugador.setRenos(cantidad);
        if (user.getMonedas()>100*cantidad){
            int monedas = (user.getMonedas()-100*cantidad);
            cantidad=jugador.getRenos()+cantidad;
            updateUser(user.getNickname(), monedas, cantidad);
        }else
            log.error("No tienes dinero");

    }

    public void logout(String nickname, int nivel, int regalos, int renos) throws UserNotFoundException {
        Session session = null;
        User user= getUser(nickname);
        String iduser = user.getIduser();

        Jugador jugador = getJugador(iduser);
        jugador.setRegalos(regalos);
        jugador.setRenos(nivel);
        try {

            session = FactorySession.openSession();

            session.update(Jugador.class, iduser);
            user = (User)session.get(User.class, iduser);
            user.setConectado(false);
            session.update(user, iduser);
        }
        catch(Exception e){
            log.error("Error MYSQL" +e.getMessage());
            throw new UserNotFoundException();
        }
        finally {
            session.close();
        }

    }

    private Jugador getJugador(String iduser) {
        Session session = null;
        Jugador jugador=null;
        try {
            session = FactorySession.openSession();
            jugador = (Jugador)session.get(Jugador.class, iduser);
        }
        catch (Exception e) {
            log.error("Error MSQL "+this.getClass());
        }
        finally {
            session.close();
        }

        return jugador;


    }






}

