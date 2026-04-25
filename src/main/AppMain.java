package main;

import java.util.Scanner;
import service.BookService;
import service.UserService;
import service.TransactionService;

public class AppMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookService bookService = new BookService();
        UserService userService = new UserService();
        TransactionService transactionService = new TransactionService();

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    bookService.addBook(bookId, title, author);
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();

                    userService.addUser(userId, name);
                    break;

                case 3:
                    System.out.print("Enter title or author keyword: ");
                    String keyword = sc.nextLine();

                    bookService.searchBook(keyword);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int issueUserId = sc.nextInt();

                    transactionService.issueBook(issueBookId, issueUserId);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    transactionService.returnBook(returnBookId);
                    break;

                case 6:
                    System.out.println("Thank you! Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}