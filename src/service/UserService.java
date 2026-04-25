package service;

import dao.UserDAO;
import model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void addUser(int userId, String name) {
        User user = new User(userId, name);
        userDAO.addUser(user);
    }
}