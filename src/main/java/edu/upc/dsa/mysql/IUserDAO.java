package edu.upc.dsa.mysql;

import edu.upc.dsa.models.Objects;
import edu.upc.dsa.models.User;

import java.util.List;

public interface IUserDAO {

    public String addUser(String nickname, String name, String password);
    public User getUser(String nickname);
    public void updateUser(String nickname, int monedas, List<Objects> objectList);
    public void deleteUser(String nickname);
    public List<User> getUsers();
    //public List <User> getEmployeeByDept(int deptId);
}
