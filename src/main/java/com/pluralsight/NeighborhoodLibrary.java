package com.pluralsight;
import java.util.Scanner;

class NeighborhoodLibrary {
    public static void main(String[] args) {
        // Create an array to hold the inventory of books
        Book[] books = new Book[5]; // Assuming there are 5 books

        // Add at least 5 Book objects to the array
        books[0] = new Book(1, "978-0439139595", "Harry Potter and the Sorcerer's Stone");
        books[1] = new Book(2, "978-0439064873", "Harry Potter and the Chamber of Secrets");
        books[2] = new Book(3, "978-0439136365", "Harry Potter and the Prisoner of Azkaban");
        books[3] = new Book(4, "978-0439139601", "Harry Potter and the Goblet of Fire");
        books[4] = new Book(5, "978-0439358071", "Harry Potter and the Order of the Phoenix");

        // Display home screen options
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Library System!");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");

            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    showAvailableBooks(books, scanner);
                    break;
                case 2:
                    showCheckedOutBooks(books, scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Show available books
    public static void showAvailableBooks(Book[] books, Scanner scanner) {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }

        System.out.println("Choose a book to check out (Enter ID) or enter 'exit' to go back to the home screen:");
        String input = scanner.nextLine();
        if (!input.equals("exit")) {
            int bookId = Integer.parseInt(input);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            for (Book book : books) {
                if (book != null && book.getId() == bookId) {
                    book.checkOut(name);
                    break;
                }
            }
        }
    }

    // Show checked out books
    public static void showCheckedOutBooks(Book[] books, Scanner scanner) {
        System.out.println("Checked Out Books:");
        for (Book book : books) {
            if (book != null && book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked Out To: " + book.getCheckedOutTo());
            }
        }

        System.out.println("Choose an option:");
        System.out.println("C - to Check In a book");
        System.out.println("X - to go back to the home screen");

        String option = scanner.nextLine();
        switch (option) {
            case "C":
                checkInBook(books, scanner);
                break;
            case "X":
                break; // Do nothing, go back to home screen
            default:
                System.out.println("Invalid option.");
        }
    }

    // Check in a book
    public static void checkInBook(Book[] books, Scanner scanner) {
        System.out.print("Enter the ID of the book you want to check in: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Book book : books) {
            if (book != null && book.getId() == bookId) {
                book.checkIn();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}


