package service;

import dao.BookDAO;
import model.Book;

public class BookService {

    private BookDAO bookDAO = new BookDAO();

    public void addBook(int bookId, String title, String author) {
        Book book = new Book(bookId, title, author);
        bookDAO.addBook(book);
    }

    public void searchBook(String keyword) {
        bookDAO.searchBook(keyword);
    }
}