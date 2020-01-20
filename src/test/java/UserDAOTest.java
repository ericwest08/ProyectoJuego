import edu.upc.dsa.exceptions.UserAlreadyConnectedException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.User;
import edu.upc.dsa.mysql.IUserDAO;
import edu.upc.dsa.mysql.UserDAOImpl;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {

    private IUserDAO gm = null;
    final static Logger log = Logger.getLogger(UserDAOTest.class.getName());


    @Before
    public void setUp(){
        this.gm = UserDAOImpl.getInstance();
        this.gm.addUser("erwest", "Eric", "erwest");
        this.gm.addUser("19zandu", "Joseph", "19zandu");
        this.gm.addUser("guidobetcher", "Guido", "guidobetcher");



    }


    @After
    public void tearDown() {
        this.gm.clear();
    }

    @Test
    public void testLogin() throws UserNotFoundException, UserAlreadyConnectedException {
        Jugador j1 = new Jugador();
        User u = new User("A12", "Alvaro", "111");
        String nickname = u.getNickname();
        String password = u.getPassword();
        j1.setIduser(u.getIduser());
        Assert.assertEquals(j1, gm.loginUser(nickname,password));
    }
    @Test
    public void insertUserDB() throws UserNotFoundException, UserAlreadyConnectedException {
        this.gm = UserDAOImpl.getInstance();
        this.gm.loginUser("Carlos", "Carlos");
        Assert.assertEquals(0, this.gm.loginUser("Carlos1", "Carlos").getRegalos());
        this.gm.clear();
    }
    @Test
    public void getUserTest(){
        Assert.assertEquals("e",
                this.gm.getUser("19zandu"));
    }


    @Test
    public void deleteUsertest() throws UserNotFoundException {
        this.gm.deleteUser("erwest");
        Assert.assertEquals(2, this.gm.numUsers());
        this.gm.clear();
    }


}



