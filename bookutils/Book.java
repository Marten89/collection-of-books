package bookutils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing book objects.
 * Implements interfaces Comparable and Serializable.
 */
public class Book implements Comparable<Book>, Serializable {

    private final String title;
    private final Genre genre;
    private final int rating;
    private final ArrayList<Author> theAuthors;
    private final Isbn isbn;
    
    /**
     * Create a new Book object.
     * @param title the book's title.
     * @param genre the book's genre.
     * @param rating the book's rating.
     * @param isbn the book's ISBN-number.
     */
    public Book(String title, Genre genre, int rating, String isbn) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.theAuthors = new ArrayList<Author>();
        this.isbn = Isbn.createIsbn(isbn);
    }
    
    /**
     * Add author to list of authors for the book object.
     * @param author the author to be added to list of authors.
     */
    public void addAuthor(Author author) {
	theAuthors.add(author);
    }
    
    /**
     * Return a list of the authors of the book object.
     * @return a list of the authors of the book object.
     */
    public List<Author> getAuthors() {
        return (List<Author>) theAuthors.clone();
    }
    
    /**
     * Return a String with the title of the book object.
     * @return the title of the book object.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Return a String representing the ISBN-number of the book object.
     * @return a String representing the ISBN-number of the book object.
     */
    public String getIsbn() {
        return isbn.getIsbnString();
    }
    
    /**
     * Compare this book with other book with first key title and
     * second key rating.
     * @param other book object to compare this book with.
     * @return a positive int if this book > other book,
     * a negative int if other book > this book and 0 if they are alike.
     */
    @Override
    public int compareTo(Book other) {
        String thisTitle = this.title.toLowerCase();
        String otherTitle = other.title.toLowerCase();
        int result = thisTitle.compareTo(otherTitle);
        if (result == 0) {
            result = this.rating - other.rating;
        }
        return result;        
    }
    
    /**
     * Compare two objects, return true if equal as defined
     * by compareTo, false otherwise.
     * @param other object to compare this object with.
     * @return true only if the objects are equal as defined by
     * compareTo, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Book)) {
            return false;
        }
        Book otherBook = (Book) other;
        return (this.compareTo(otherBook) == 0);
    }

    @Override
    public String toString() {
        return "'" + title + "'" + ", Authors: " + theAuthors + ", genre: " + genre + ", rating: " + rating + ", " + isbn;
    }
    
    
}
