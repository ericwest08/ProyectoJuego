import java.util.LinkedList;
import java.util.List;

public interface GameManager {

    int size();
    void addUser(String iduser, String name, String surname);
    LinkedList<User> userlistordered();
    User modifyuser(User u);
    int numUsers();
    User getinfouser (String iduser);
    void addObject(String idObject, String nameObject, int priceObject);
    LinkedList<Objects> objectsofuser (String iduser);
    int numObjects(String iduser);




}
