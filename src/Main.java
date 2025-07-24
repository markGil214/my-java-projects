import java.util.Scanner;
import java.util.ArrayList;
class Book {
    String title;
    String author;
    boolean isBorrowed;

    Book(String title, String author, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }


}

class LibraryManager {
    ArrayList<Book> book = new ArrayList<>();
    Scanner scanner;




    void addBook() {
        Boolean isBorrowed = true;
        scanner = new Scanner(System.in);
        String title;
        String author;
        System.out.print("Enter Book title: ");
        title = scanner.nextLine();
        System.out.print("Enter Author: ");
        author = scanner.nextLine();
        try {
            book.add(new Book(title, author, isBorrowed));
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert book.");
        }
        System.out.println("✅ Book added successfully!");

    }

    void removeBook() {
        String choice;
        System.out.println("Enter book title to remove: ");
        choice = scanner.nextLine();
        int index = 0;

        for (Book books : book) {
            if (book.get(index).title.equalsIgnoreCase(choice)) {
                book.remove(index);
                System.out.println("✅ Book borrowed successfully!");
            } else {
                System.out.println("The book you typed was not on the list");
            }
            index++;
        }

    }

    void listBooks() {
        System.out.println("\uD83D\uDCDA Current Library Books:");
        int index = 1;
            for (Book books : book) {
                if (books.isBorrowed) {
                    System.out.println(index + ". " + books.title + " by " + books.author
                            + "[Available]");
                    index++;
                } else {
                    System.out.println(index + " " + books.title + " by " + books.author
                            + "[Not Available]");
                    index++;
                }
            }

    }

    void borrowBook() {
        String choice;
        System.out.println("Enter book title to borrow: ");
        choice = scanner.nextLine();

        for (Book books : book) {
            if (books.title.equals(choice.toLowerCase())) {
                books.isBorrowed = false;
                System.out.println("✅ Book borrowed successfully!");
            } else {
                System.out.println("The book you typed was not on the list");
            }
        }


    }

    void returnBook() {
        String choice;
        System.out.println("Enter book title to return: ");
        choice = scanner.nextLine();

        for (Book books : book) {
            if (books.title.equals(choice.toLowerCase())) {
                books.isBorrowed = true;
                System.out.println("✅ Book returned successfully!");
            } else {
                System.out.println("The book you typed was not on the list");
            }
        }
    }


}

class Menu {
    Scanner scanner;
    int choice;
    LibraryManager libraryManager;

    void show() {
        libraryManager = new LibraryManager();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Library Menu ===");
            System.out.println("1. Add book");
            System.out.println("2. Remove Book");
            System.out.println("3. List all Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1:
                    libraryManager.addBook();
                    break;
                case 2:
                    libraryManager.removeBook();
                    break;
                case 3:
                    libraryManager.listBooks();
                    break;
                case 4:
                    libraryManager.borrowBook();
                    break;
                case 5:
                    libraryManager.returnBook();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0); // Terminates the JVM
                    break;
                default:
                    System.out.println("Enter a valid key.");

            }
        }
    }



}


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.show();
    }
}