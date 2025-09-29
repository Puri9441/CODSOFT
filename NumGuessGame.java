!import java.util.Random;
import java.util.Scanner;

public class NumGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int maxAttempts = 10;
        int score = 0;
        int round = 0;

        while (playAgain) {
             int attempts = 0;
            int min = 1;
            int max =100;
            int GuessNumber = random.nextInt(min ,max) + 1;
            boolean  correctguess = false;
            round++;

            System.out.printf(" Round " + round + ": Guess the number between %d and %d!",min,max);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int UserGuessNum;
                if (!scanner.hasNextInt()) 
                {
                    System.out.println("Please enter a valid number!");
                    scanner.next();
                    continue;
                }

                UserGuessNum = scanner.nextInt();
                attempts++;

                if (UserGuessNum == GuessNumber)
                 {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempt(s).");
                    score++;
                    correctguess = true;
                    break;
                } 
                else if (UserGuessNum < GuessNumber)
                 {
                    System.out.println("Too low!");
                }
                 else
                  {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!correctguess) 
            {
                System.out.println("You've used all attempts. The correct number was: " + GuessNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes"))
             {
                playAgain = false;
            }
        }

        System.out.println(" Game Over! You won " + score + " round(s).");
        scanner.close();
    }
}


