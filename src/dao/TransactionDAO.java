package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TransactionDAO {

    public void issueBook(int bookId, int userId) {

        String checkSql =
            "SELECT is_issued FROM books WHERE book_id = ?";
        String insertSql =
            "INSERT INTO transactions(book_id, user_id, issue_date, due_date) " +
            "VALUES (?, ?, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 7 DAY))";
        String updateBookSql =
            "UPDATE books SET is_issued = true WHERE book_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, bookId);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next() && rs.getBoolean("is_issued")) {
                System.out.println("Book already issued");
                return;
            }

            con.setAutoCommit(false);

            PreparedStatement insertPs = con.prepareStatement(insertSql);
            insertPs.setInt(1, bookId);
            insertPs.setInt(2, userId);
            insertPs.executeUpdate();

            PreparedStatement updatePs = con.prepareStatement(updateBookSql);
            updatePs.setInt(1, bookId);
            updatePs.executeUpdate();

            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId) {

        String fetchSql =
            "SELECT due_date FROM transactions WHERE book_id = ? AND return_date IS NULL";
        String updateTxnSql =
            "UPDATE transactions SET return_date = CURDATE(), fine = ? " +
            "WHERE book_id = ? AND return_date IS NULL";
        String updateBookSql =
            "UPDATE books SET is_issued = false WHERE book_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement fetchPs = con.prepareStatement(fetchSql);
            fetchPs.setInt(1, bookId);
            ResultSet rs = fetchPs.executeQuery();

            if (!rs.next()) {
                System.out.println("No active transaction found");
                return;
            }

            LocalDate dueDate =
                rs.getDate("due_date").toLocalDate();
            LocalDate returnDate = LocalDate.now();

            double fine = 0;
            if (returnDate.isAfter(dueDate)) {
                fine =
                    ChronoUnit.DAYS.between(dueDate, returnDate) * 5;
            }

            PreparedStatement updateTxnPs =
                con.prepareStatement(updateTxnSql);
            updateTxnPs.setDouble(1, fine);
            updateTxnPs.setInt(2, bookId);
            updateTxnPs.executeUpdate();

            PreparedStatement updateBookPs =
                con.prepareStatement(updateBookSql);
            updateBookPs.setInt(1, bookId);
            updateBookPs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}