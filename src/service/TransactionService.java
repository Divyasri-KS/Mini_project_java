package service;

import dao.TransactionDAO;

public class TransactionService {

    private TransactionDAO transactionDAO = new TransactionDAO();

    public void issueBook(int bookId, int userId) {
        transactionDAO.issueBook(bookId, userId);
    }

    public void returnBook(int bookId) {
        transactionDAO.returnBook(bookId);
    }
}