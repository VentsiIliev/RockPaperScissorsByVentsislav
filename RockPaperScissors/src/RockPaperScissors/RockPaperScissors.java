package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many rounds would you like to play?");
        int rounds = Integer.parseInt(scanner.nextLine());

        System.out.println("Choose wisely");
        System.out.println("[r]ock");
        System.out.println("[p]aper");
        System.out.println("[s]cissors");

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {

            String userInput = scanner.nextLine();

            while (
                    !"r".equals(userInput) && !"p".equals(userInput) && !"s".equals(userInput)) {
                System.out.println("Invalid input.");
                System.out.println("Please enter a valid number ([r]ock, [p]aper, [s]cissors).");
                userInput = scanner.nextLine();
            }

            String userChoice = "";
            if ("r".equals(userInput)) {
                userChoice = "Rock";
            } else if ("p".equals(userInput)) {
                userChoice = "Paper";
            } else {
                userChoice = "Scissors";
            }

            System.out.printf("You chose %s!\n", userChoice);

            Random random = new Random();
            int randomNumber = random.nextInt(3);

            String computerMove = "";
            if (randomNumber == 0) {
                computerMove = "Rock";
            } else if (randomNumber == 1) {
                computerMove = "Paper";
            } else {
                computerMove = "Scissors";
            }

            System.out.printf("The computer chose %s!\n", computerMove);

            if ("r".equals(userInput) && randomNumber == 2) {
                playerWins++;
                System.out.println("YOU WIN!!");
            } else if ("p".equals(userInput) && randomNumber == 0) {
                playerWins++;
                System.out.println("YOU WIN!");
            } else if ("s".equals(userInput) && randomNumber == 1) {
                playerWins++;
                System.out.println("YOU WIN!");
            } else if (userChoice.equals(computerMove)) {
                draws++;
                System.out.println("It`s a draw");
            } else {
                computerWins++;
                System.out.println("YOU LOST!");
            }
            System.out.println("************************");
        }

        System.out.println("Stats");
        System.out.printf("You %d : %d Computer\n", playerWins, computerWins);

        if (draws > 0) {
            System.out.printf("Draws: %d", draws);
        }
    }
}
