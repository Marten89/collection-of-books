import bookutils.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    
    private final CollectionOfBooks collection;
    private final Scanner scan;

    public UserInterface() {
        collection = new CollectionOfBooks();
        scan = new Scanner(System.in);
    }
    
    public void run(String filename) throws IOException {
        
        try {
        List<Book> books = BooksIO.deSerializeFromFile(filename);
        collection.addBooks(books);
        }
        catch (Exception e) {
            System.out.println("Could not load books from file, starts with empty collection of books");
        }
        char choice = ' ';
        String answer;
        
        do {
            printMainMenu();
            answer = scan.nextLine();
            answer = answer.toUpperCase();
            choice = answer.charAt(0);
            
            switch(choice) {
                case 'A': addBook(); break;
                case 'B': removeBook(); break;
                case 'C': searchForBooks(); break;
                case 'D': listAllBooks(); break;
                case 'E': BooksIO.serializeToFile(filename, collection.getBooks()); System.exit(0);
                default: System.out.println("Unknown input");
            } 
        } while (choice != 'E');
    }
    
    public void printMainMenu() {
        System.out.println();
        System.out.println("---Menu---");
        System.out.println("A: Add book");
        System.out.println("B: Remove book");
        System.out.println("C: Search for books");
        System.out.println("D: List all books");
        System.out.println("E: Exit and write to file");
        System.out.println("----------");
    }
    
    public void searchForBooks() {
        printSearchMenu();
        String answer = scan.nextLine();
        answer = answer.toUpperCase();
        char choice = answer.charAt(0);
        switch(choice) {
            case 'A': getBookByTitle(); break;
            case 'B': getBookByAuthor(); break;
            case 'C': getBookByIsbn(); break;
            default: System.out.println("Unknown input");
        } 
    }
    
    public void getBookByTitle() {
        System.out.println("State title or part of title:");
        String title = scan.nextLine();
        List<Book> matches = collection.getBooksByTitle(title);
        if (matches.isEmpty()) {
            System.out.println("No books found");
        } else {
            for (Book eachBook : matches) {
                System.out.println(eachBook);    
            }
        }
    }
    
    public void getBookByAuthor() {
        System.out.println("State name or part of name of Author:");
        String name = scan.nextLine();
        List<Book> matches = collection.getBooksByAuthor(name);
        if (matches.isEmpty()) {
            System.out.println("No books found");
        } else {
            for (Book eachBook : matches) {
                System.out.println(eachBook);    
            }
        }
    }

    public void getBookByIsbn() {
        System.out.println("State ISBN-number or part of ISBN-number:");
        String isbn = scan.nextLine();
        List<Book> matches = collection.getBooksByIsbn(isbn);
        if (matches.isEmpty()) {
            System.out.println("No books found");
        } else {
            for (Book eachBook : matches) {
                System.out.println(eachBook);    
            }
        }
    }    
    
    public void printSearchMenu() {
        System.out.println();
        System.out.println("---Menu---");
        System.out.println("A: Search by title");
        System.out.println("B: Search by author");
        System.out.println("C: Search by ISBN-number");
        System.out.println("----------");
    }
    
    public void listAllBooks() {
        collection.sortBooks();
        List<Book> allBooks = collection.getBooks();
        for (Book eachBook : allBooks) {
            System.out.print(collection.getIndex(eachBook) + 1 + ". " );
            System.out.println(eachBook);
        }
    }
    
    public void removeBook() {
        listAllBooks();
        System.out.println();
        System.out.println("State the index of the book to be removed:");
        int index = Integer.parseInt(scan.nextLine());
        Book removedBook = collection.getBook(index - 1);
        collection.removeBook(removedBook);
    }
    
    public void addBook() {
        System.out.println("State the book's title:");
        String title = scan.nextLine();
        
        System.out.println("State the book's ISBN-number:");
        String isbn = scan.nextLine();
        
        System.out.println("State the book's rating (1/2/3/4/5):");
        int rating = Integer.parseInt(scan.nextLine());
        
        System.out.println("State the book's genre:");
        String genreString = scan.nextLine();
        genreString = genreString.replace(" ", "_").toUpperCase();
        Genre genre = Genre.valueOf(genreString);
        
        Book addedBook = new Book(title, genre, rating, isbn);
        addAuthors(addedBook);
        
    }
    
    public void addAuthors(Book addedBook) {
        char choice = ' ';
        
        do {
            System.out.println("State the Author's name:");
            String name = scan.nextLine();
            LocalDate dateOfBirth = LocalDate.now();
            Author addedAuthor = new Author(name, dateOfBirth);
            addedBook.addAuthor(addedAuthor);
            
            printAuthorMenu();
            String answer = scan.nextLine();
            answer = answer.toUpperCase();
            choice = answer.charAt(0);
            
            switch(choice) {
                case 'A': ; break;
                case 'B': ; break;
                default: System.out.println("Unknown input");
            } 
        } while (choice != 'B');
        collection.addBook(addedBook);
    }
    
    public void printAuthorMenu() {
        System.out.println();
        System.out.println("---Menu---");
        System.out.println("A: Add another author");
        System.out.println("B: Continue");
        System.out.println("----------");
    }
}
