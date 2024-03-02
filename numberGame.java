import java.util.Scanner;
import java.util.Random;

public class numberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber;
        int attempts;
        boolean playAgain = true;
        int totalAttempts = 0;
        int rounds = 0;

        System.out.println("Welcome to the Guess the Number game!");

        while (playAgain) {
            secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            attempts = 0;
            rounds++;

            System.out.println("I have chosen a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");
            
            int guess;
            boolean guessedCorrectly = false;
            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low. Try again!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high. Try again!");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts!");
                    totalAttempts += attempts;
                    guessedCorrectly = true;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = sc.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! You played " + rounds + " rounds and your total score is " + totalAttempts + ".");
        sc.close();
    }
}