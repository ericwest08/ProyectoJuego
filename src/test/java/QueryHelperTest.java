
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
        user.setName(login);
        user.setPassword(passwd);
        Assert.assertEquals("SELECT * FROM User WHERE username = ? AND password = ?",
                QueryHelper.createQueryLOGIN(user));
    }

    @Test
    public void addUserQuery(){
        User user = new User();
        String nick = "user1";
        String name = "name1";
        String passwd = "passwd1";
        user.setNickname(nick);
        user.setName(name);
        user.setPassword(passwd);
        Assert.assertEquals("INSERT INTO User (nick,name,passwd) VALUES (?,?,?)",
                QueryHelper.createQueryINSERT(user));

    }

    @Test
    public void getUserQuery(){
        User user = new User();
        String nick = "nickkk";
        user.setNickname(nick);
        Assert.assertEquals("SELECT * FROM User WHERE Nickname = ?",
                QueryHelper.createQuerySELECT(user));
    }

    @Test
    public void deleteUserQuery(){
        User user = new User();
        String nick = "nickkk";
        user.setNickname(nick);
        Assert.assertEquals("DELETE * FROM User WHERE Nickname = ?",
                QueryHelper.createQueryDELETEALL(user));
    }

    @Test
    public void getIDUserQuery(){
        User user = new User();
        String nick = "nickkk";
        String passw = "passw1";
        user.setNickname(nick);
        user.setPassword(passw);
        Assert.assertEquals("SELECT ID FROM User WHERE Nickname = ? AND Password = ?",
                QueryHelper.createQueryDELETEALL(user));
    }








}
