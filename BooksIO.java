import bookutils.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Class for reading and writing book objects from and to a file. 
 */
public class BooksIO {
    
    /**
     * Write a list of book objects to a given file.
     * @param filename the file to write the list of books to.
     * @param books list of books to write to file.
     * @throws java.io.IOException if unable to write to file.
     */
    public static void serializeToFile(String filename, List<Book> books) throws IOException {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(books);
        }
        finally {
            if (output != null) {
                output.close();
            } 
        }
    }
    
    /**
     * Get a list of book objects from a given file.
     * @param filename the file to read from.
     * @return a list with the book objects in the file.
     * @throws java.io.IOException if unable to read from file.
     * @throws java.lang.ClassNotFoundException if the file contains
     * anything other than a list of book objects.
     */
    public static List<Book> deSerializeFromFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(filename));
            List<Book> books = (List<Book>) input.readObject(); //Downcast from object to list of books
            return books;
        }
        finally {
            if (input != null) {
                input.close();
            } 
        }
    }
}
