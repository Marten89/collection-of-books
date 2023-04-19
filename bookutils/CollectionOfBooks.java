package bookutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for a collection of book objects.
 */
public class CollectionOfBooks {
    
    private final ArrayList<Book> theBooks;
    
    /**
     * Create a new CollectionOfBooks-object.
     */
    public CollectionOfBooks() {
        this.theBooks = new ArrayList<>();    
    }
    
    /**
     * Return the number of book objects in the collection.
     * @return the number of books in the collection.
     */
    public int getSize() {
        return theBooks.size();
    }
    
    /**
     * Add a book to the end of the collection.
     * @param book to be added.
     * @throws IllegalArgumentException if the book is null.
     */
    public void addBook(Book book) throws IllegalArgumentException {
        if (book == null) {
            throw new IllegalArgumentException("Argument book is null");
        } else {
            theBooks.add(book);
        }
    }
    
    /**
     * Add a list of books to the end of the collection.
     * @param books to be added.
     * @throws IllegalArgumentException if books is null.
     */
    public void addBooks(List<Book> books) throws IllegalArgumentException {
        if (books == null) {
            throw new IllegalArgumentException("Argument books is null");
        } else {
            for (Book eachBook : books) {
            theBooks.add(eachBook);
            }
        }
    }
    
    /**
     * Remove a specific book from the collection, if present.
     * @param book to be removed.
     * @return true if the collection is changed, false otherwise.
     */
    public boolean removeBook(Book book) {
        return theBooks.remove(book);
    }
    
    /**
     * Sort the books by title.
     */
    public void sortBooks() {
        Collections.sort(theBooks);
    }
    
    /**
     * Creates a copy of the list of books.
     * @return a copy of the list of books.
     */
    public List<Book> getBooks() {
        return (List<Book>) theBooks.clone();
    }
    
    /**
     * Return the book at the position in the collection
     * given by an index.
     * @param index of the book.
     * @return the book at the given index.
     */
    public Book getBook(int index) {
        return theBooks.get(index);
    }
    
    /**
     * Return the position (index) of a given book in the collection.
     * @param book.
     * @return the index of the given book.
     */
    public int getIndex(Book book) {
        return theBooks.indexOf(book);
    }
    
    /**
     * Find books were the search term matches part of the title.
     * Returns a sorted list with the matching book objects.
     * @param searchString search term for book titles.
     * @return list of matching books sorted by title.
     */
    public List<Book> getBooksByTitle(String searchString) {
        searchString = searchString.trim().toLowerCase();
        List<Book> matches = new ArrayList<>();
        for (Book eachBook : theBooks) {
            String title = eachBook.getTitle().toLowerCase();
            if (title.contains(searchString)) {
                matches.add(eachBook);
            }
        }
        Collections.sort(matches);
        return matches;
    }
    
    /**
     * Find books were the search term matches part of the name
     * of one or more authors. Returns a sorted list with the 
     * matching book objects.
     * @param searchString search term for author names.
     * @return list of matching books sorted by title.
     */
    public List<Book> getBooksByAuthor(String searchString) {
        searchString = searchString.trim().toLowerCase();
        List<Book> matches = new ArrayList<>();
        for (Book eachBook : theBooks) {
            List<Author> authors = eachBook.getAuthors();
            for (Author eachAuthor : authors) {
                String name = eachAuthor.getName().toLowerCase();
                if (name.contains(searchString)) {
                    matches.add(eachBook);
                }
            }
        }
        Collections.sort(matches);
        return matches;
    }
    
    /**
     * Find books were the search term matches part of the ISBN-number.
     * Returns a sorted list with the matching book objects.
     * @param searchString search term for ISBN-number.
     * @return list of matching books sorted by title.
     */
    public List<Book> getBooksByIsbn(String searchString) {
        searchString = searchString.replace("-", "").replace(" ", "");
        List<Book> matches = new ArrayList<>();
        for (Book eachBook : theBooks) {
            String isbn = eachBook.getIsbn();
            if (isbn.contains(searchString)) {
                matches.add(eachBook);
            }
        }
        Collections.sort(matches);
        return matches;
    }

    @Override
    public String toString() {
        Collections.sort(theBooks);
        return "CollectionOfBooks{" + "theBooks=" + theBooks + '}';
    }     
}
