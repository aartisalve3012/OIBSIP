
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int rounds = 3;

        System.out.println("=================================");
        System.out.println("      GUESS THE NUMBER GAME");
        System.out.println("=================================");

        System.out.println("Developed by Arati Salve");

        // Difficulty Selection
        System.out.println("\nChoose Difficulty Level:");
        System.out.println("1. Easy (10 Attempts)");
        System.out.println("2. Medium (7 Attempts)");
        System.out.println("3. Hard (5 Attempts)");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        int maxAttempts;

        switch (choice) {
            case 1:
                maxAttempts = 10;
                break;
            case 2:
                maxAttempts = 7;
                break;
            case 3:
                maxAttempts = 5;
                break;
            default:
                System.out.println("Invalid Choice! Easy mode selected.");
                maxAttempts = 10;
        }

        for (int round = 1; round <= rounds; round++) {

            int secretNumber = random.nextInt(100) + 1;
            boolean guessedCorrectly = false;

            System.out.println("\n=================================");
            System.out.println("Round " + round);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("Attempts Available: " + maxAttempts);
            System.out.println("=================================");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.next();
                    attempt--;
                    continue;
                }

                int guess = sc.nextInt();

                if (guess == secretNumber) {

                    int points = (maxAttempts - attempt + 1) * 10;
                    totalScore += points;

                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts Used: " + attempt);
                    System.out.println("Points Earned: " + points);

                    guessedCorrectly = true;
                    break;
                }

                else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                }

                else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left: "
                        + (maxAttempts - attempt));
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: "
                        + secretNumber);
            }
        }

        System.out.println("\n=================================");
        System.out.println("FINAL RESULT");
        System.out.println("=================================");
        System.out.println("Total Score: " + totalScore);

        if (totalScore >= 150) {
            System.out.println("Excellent Performance!");
        } else if (totalScore >= 80) {
            System.out.println("Good Job!");
        } else {
            System.out.println("Keep Practicing!");
        }
        System.out.println("Thank you for playing!");

        sc.close();
    }
}
