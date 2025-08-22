import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperationsScript {
    private static final String FILENAME = "demo.txt";

    public static void main(String[] args) {
        System.out.println("--- Writing to file ---");
        String initialContent = "Hello!\nMy name is Ayush Kumar.";
        writeFile(FILENAME, initialContent, false);
        System.out.println("Initial content written successfully.\n");

        System.out.println("--- Reading from file ---");
        System.out.println("File content before modification:");
        readFile(FILENAME);
        System.out.println("Read operation completed.\n");

        System.out.println("--- Modifying (appending) the file ---");
        String contentToAppend = "\n\nAppended this line to the end.";
        writeFile(FILENAME, contentToAppend, true);
        System.out.println("Content appended successfully.\n");

        System.out.println("--- Reading the modified file ---");
        System.out.println("File content after modification:");
        readFile(FILENAME);
        System.out.println("Final read operation completed.\n");
    }

    public static void writeFile(String filename, String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}