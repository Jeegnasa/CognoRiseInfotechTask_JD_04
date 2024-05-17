import java.util.Random;
import java.util.Scanner;
//Task-04
public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "strawberry", "watermelon"}; // List of words to choose from
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String wordToGuess = words[random.nextInt(words.length)]; // Select a random word
        char[] wordProgress = new char[wordToGuess.length()]; // Array to track guessed letters
        for (int i = 0; i < wordProgress.length; i++) {
            wordProgress[i] = '_'; // Initialize to underscores
        }

        int maxAttempts = 6; // Maximum incorrect guesses allowed
        int attempts = 0; // Current incorrect guesses

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");

        while (attempts < maxAttempts) {
            System.out.println("Word: " + String.valueOf(wordProgress));

            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().charAt(0);

            boolean found = false; // Flag to track if the guess is correct
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    wordProgress[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                attempts++;
                displayHangman(attempts);
                System.out.println("Incorrect guess. Attempts left: " + (maxAttempts - attempts));
            }

            // Check if the word has been completely guessed
            if (String.valueOf(wordProgress).equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        if (attempts >= maxAttempts) {
            System.out.println("Sorry, you ran out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    public static void displayHangman(int attempts) {
        String[] hangman = {
            "  ____\n |    |\n      |\n      |\n      |\n______|",
            "  ____\n |    |\n O    |\n      |\n      |\n______|",
            "  ____\n |    |\n O    |\n |    |\n      |\n______|",
            "  ____\n |    |\n O    |\n/|    |\n      |\n______|",
            "  ____\n |    |\n O    |\n/|\\   |\n      |\n______|",
            "  ____\n |    |\n O    |\n/|\\   |\n/     |\n______|",
            "  ____\n |    |\n O    |\n/|\\   |\n/ \\   |\n______|"
        };
        
        System.out.println(hangman[attempts]);
    }
}
