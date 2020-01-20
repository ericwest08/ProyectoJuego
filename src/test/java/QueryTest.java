import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.User;
import edu.upc.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class QueryTest {
    @Before
    public void setUp(){

    }


    @Test
    public void testQueryINSERTSIMPLE() {
        Assert.assertEquals("INSERT INTO User (iduser, nickname, name, password) VALUES (?, ?, ?, ?)",
                QueryHelper.createQueryINSERTSIMPLE(new User("Juan93", "Juan", "3333")));
    }
    @Test
    public void testQuerySELECT() {
        Assert.assertEquals("SELECT * FROM User WHERE iduser = ?",
                QueryHelper.createQuerySELECT(new User("Juan", "lopez", "333333")));
    }
    @Test
    public void testQueryIDUSER(){
        Assert.assertEquals("SELECT iduser FROM User WHERE nickname = ? AND password = ?",
            QueryHelper.createQueryIDUSER(User.class));
    }

    @Test
    public void testQueryUPDATE(){
        User user= new User("Toni76", "Toni", "1111");
        user.mockId("d3395cf5-05c0-4ef2-bdcb-4a55d9880114");
        user.setConectado(true);
        Assert.assertEquals("UPDATE User SET iduser = ?, nickname = ?, name = ?, password = ?, monedas = ?, renos = ?, conectado = ? WHERE iduser = ?",
                QueryHelper.createQueryUPDATE(user));
    }
    //public static String createQueryINSERT(Object entity)
    /*
    @Test
    public void testQueryINSERT2() {
        Assert.assertEquals("INSERT INTO Deparment (ID, name, description) VALUES (?, ?, ?)",
                QueryHelper.createQueryINSERT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA")));
    }

    @Test
    public void testQuerySELECT() {
        Assert.assertEquals("SELECT * FROM Employee WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Employee("Juan", "lopez", 333333)));
    }

    @Test
    public void testQuerySELECT2() {
        Assert.assertEquals("SELECT * FROM Deparment WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA")));
    }
    @Test
    public void testQueryLogin() {
        User user = new User();
        String login = "user1";
        String passwd = "passwd1";
        user.setNameuser(login);
        user.setPassword(passwd);
        Assert.assertEquals("SELECT * FROM User WHERE username = ? AND password = ?",
                QueryHelper.createQueryLOGIN(user));
    }*/

}
