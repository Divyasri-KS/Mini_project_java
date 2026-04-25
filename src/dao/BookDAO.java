package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Book;

public class BookDAO {

    public void addBook(Book book) {

        String sql =
            "INSERT INTO books(book_id, title, author, is_issued) VALUES (?, ?, ?, false)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchBook(String keyword) {

        String sql =
            "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                    rs.getInt("book_id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | Issued: " +
                    rs.getBoolean("is_issued"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}