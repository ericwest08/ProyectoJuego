package edu.upc.dsa.mysql;

import edu.upc.dsa.models.User;

import java.util.List;

public interface IUserDAO {

    String addUser(String nickname, String name, String password);
    User getUser(String nickname);
    void updateUser(String nickname, int monedas, int renos);
    void deleteUser(String nickname);
    List<User> getUsers();
    //public List <User> getEmployeeByDept(int deptId);
}
