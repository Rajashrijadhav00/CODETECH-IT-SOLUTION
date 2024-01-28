package task2;
import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame 
{

	    public static void main(String[] args) {
	        // Generate a random number between 1 and 100
	        Random random = new Random();
	        int secretNumber = random.nextInt(100) + 1;

	        // Set the maximum number of attempts
	        int maxAttempts = 10;
	        int attempts = 0;

	        // Create a Scanner for user input
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Welcome to the Number Guessing Game!");
	        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

	        while (attempts < maxAttempts) {
	            System.out.print("Enter your guess: ");
	            int userGuess = scanner.nextInt();
	            attempts++;

	            if (userGuess == secretNumber) {
	                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
	                break;
	            } else if (userGuess < secretNumber) {
	                System.out.println("Too low. Try again.");
	            } else {
	                System.out.println("Too high. Try again.");
	            }
	        }

	        // If the player couldn't guess the number within the allowed attempts
	        if (attempts == maxAttempts) {
	            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
	        }

	        // Close the Scanner
	        scanner.close();
	    }
	}


