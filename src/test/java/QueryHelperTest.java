
import edu.upc.dsa.models.*;
import edu.upc.dsa.util.QueryHelper;

import org.junit.Assert;
import org.junit.Test;

public class QueryHelperTest {

    /*
    @Test
    public void testQueryINSERT() {
        Assert.assertEquals("INSERT INTO User (ID, name, surname, salary) VALUES (?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new User("Juan", "lopez", "3333")));
    }

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
    }*/

    @Test
    public void testQueryLogin() {
        User user = new User();
        String login = "user1";
        String passwd = "passwd1";
        user.setNameuser(login);
        user.setPassword(passwd);
        Assert.assertEquals("SELECT * FROM User WHERE username = ? AND password = ?",
                QueryHelper.createQueryLOGIN(user));
    }
}
