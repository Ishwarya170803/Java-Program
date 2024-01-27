import java.util.Scanner;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word Counter");

        // Step 1: Prompt the user to enter a text or provide a file.
        System.out.print("Enter text or provide a file path: ");
        String input = scanner.nextLine();

        // Step 2: Read the input text or file and store it in a string.
        String text = "";
        if (isFilePath(input)) {
            try {
                text = readFile(input);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                return;
            }
        } else {
            text = input;
        }

        // Step 3: Split the string into an array of words using space or punctuation as delimiters.
        String[] words = text.split("[\\s\\p{Punct}]+");

        // Step 4: Initialize a counter variable to keep track of the number of words.
        int wordCount = 0;

        // Step 5: Iterate through the array of words and increment the counter for each word encountered.
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }

        // Step 6: Display the total count of words to the user.
        System.out.println("Total words: " + wordCount);

        // You can further enhance the project with the mentioned features.
        // ...

        scanner.close();
    }

    private static boolean isFilePath(String input) {
        // Check if the input is a file path.
        return Files.isRegularFile(Paths.get(input));
    }

    private static String readFile(String filePath) throws IOException {
        // Read the contents of the file and return as a string.
        Path path = Paths.get(filePath);
        return new String(Files.readAllBytes(path));
    }
}
