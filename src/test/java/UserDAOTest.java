import edu.upc.dsa.exceptions.UserNotFoundException;
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
    public void deleteUsertest() throws UserNotFoundException {

        this.gm.deleteUser("erwest");
        Assert.assertEquals(2, this.gm.numUsers());
        this.gm.clear();
    }


}



