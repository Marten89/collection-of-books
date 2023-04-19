package bookutils;

import java.io.Serializable;

/**
 * Class representing ISBN-number for book objects.
 * Implements interface Serializable.
 */
public class Isbn implements Serializable {

    private final String isbnString;
    private static final String isbnPattern = "[0-9]{13}";
    
    private Isbn(String isbnString) throws IllegalArgumentException {
        isbnString = isbnString.replace("-", "").replace(" ", "");
        if (!isbnString.matches(isbnPattern)) {
            throw new IllegalArgumentException("illegal isbn: " + isbnString);
        }
        this.isbnString = isbnString;
    }
    
    /**
     * Create an Isbn-object matching a given String.
     * @param isbnString String representing the ISBN-number of a book object.
     * @return a new Isbn object matching the given String.
     * @throws IllegalArgumentException if the given String does
     * not match the format of an ISBN-number.
     */
    public static Isbn createIsbn(String isbnString) throws IllegalArgumentException {
        return new Isbn(isbnString);
    }
    
    /**
     * Return a String representing the Isbn-objct.
     * @return a String representing the Isbn-object.
     */
    public String getIsbnString() {
        return isbnString;
    }

    @Override
    public String toString() {
        return "isbn: " + isbnString;
    }

}