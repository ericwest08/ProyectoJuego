
import edu.upc.dsa.mysql.GameManager;
import edu.upc.dsa.mysql.GameManagerImpl;
import edu.upc.dsa.models.Objects;
import edu.upc.dsa.exceptions.UserNotFoundException;
import org.junit.After;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GameManagerTest {
    private GameManager gm = null;
    final static Logger log = Logger.getLogger(GameManagerTest.class.getName());

    @Before
    public void setUp() {
        this.gm = GameManagerImpl.getInstance();


        this.gm.addUser("55555", "Eric", "Jimenez");
        this.gm.addUser("33333", "Eduard", "Gimeno");
        this.gm.addUser("44444", "Alan", "West");



        Objects p = new Objects("Escudo", "Pequeño", 2);
        Objects q = new Objects("Espada", "Pequeña", 1);
        this.gm.addObject("55555",p);
        this.gm.addObject("33333", q);
        this.gm.size();

    }

    @After
    public void tearDown() {
        this.gm.clear();
    }

    @Test
    public void getinfousertest(){

        Assert.assertEquals("Ver mensaje", "Eric", this.gm.getinfouser("55555").getNameuser());
        Assert.assertEquals("Ver mensaje", "Jimenez", this.gm.getinfouser("55555").getSurnameuser());
        Assert.assertEquals("Ver mensaje", "Eduard", this.gm.getinfouser("33333").getNameuser());
        Assert.assertEquals("Ver mensaje", "Gimeno", this.gm.getinfouser("33333").getSurnameuser());

    }

    @Test
    public void testobjectsofuser(){
        this.gm.objectsofuser("55555");
    }

    @Test
    public void testaddUser(){
        this.gm.addUser("45180179Z","Carl", "Watson");
        Assert.assertEquals(4, this.gm.numUsers());
    }
    @Test
    public void testuserlistordered() {
       this.gm.userlistordered();
    }

    @Test
    public void testaddObject() {
        Objects x = new Objects("Pocion", "Cura la vida", 2);
        this.gm.addObject("33333", x);
    }


    @Test
    public void testnumerousuarios(){
        this.gm.numUsers();
        Assert.assertEquals(3,3);
    }

    @Test
    public void testnumeroobjetos() throws Exception{
        try{
        this.gm.numObjects("55555");
        Assert.assertEquals(1,1);
        }

        catch(UserNotFoundException a){
            log.error("The user doesn't exist, " + a.getMessage());
        }
    }

    @Test
    public void testmodifyuser() throws Exception{

        this.gm.modifyuser("55555", "Erik" , "J");
        //String iduser, boolean namesurname, String newstring
            Assert.assertEquals("Erik", this.gm.getinfouser("55555").getNameuser());

    }

}











