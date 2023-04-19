package bookutils;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class representing authors of book objects.
 * Implements interface Serializable.
 */
public class Author implements Serializable {
    
    private final String name;
    private final LocalDate dateOfBirth;
    
    /**
     * Create a new Author object.
     * @param name author's name.
     * @param dateOfBirth author's date of birth.
     */
    public Author(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * Return the name of the author.
     * @return String representing the name of the author.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Return the birth date of the author.
     * @return LocalDate representing the birth date of the author.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return name;
    }
}
