import java.io.IOException;

/**
 * Main class for collection of books. 
 */
public class Main {
    
    /**
     * Main method for collection of books.
     * @param args name of file to read to and write from.
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        String filename = args[0];
        UserInterface ui = new UserInterface();
        ui.run(filename);
    }    
}
