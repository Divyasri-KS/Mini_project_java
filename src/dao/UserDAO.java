package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;

public class UserDAO {

    public void addUser(User user) {

        String sql =
            "INSERT INTO users(user_id, name) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getName());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}