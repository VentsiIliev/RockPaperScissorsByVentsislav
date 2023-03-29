package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many rounds would you like to play?");
        int rounds = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rounds; i++) {


            System.out.println("Choose wisely");
            System.out.println("Press 0 for Rock");
            System.out.println("Press 1 for Paper");
            System.out.println("Press 2 for Scissors");

            int userInput = Integer.parseInt(scanner.nextLine());

            while (userInput != 0 && userInput != 1 && userInput != 2) {
                System.out.println("Invalid input.");
                System.out.println("Please enter a valid number (0, 1, 2).");
                userInput = Integer.parseInt(scanner.nextLine());
            }

            String userChoice = "";
            if (userInput == 0) {
                userChoice = "Rock";
            } else if (userInput == 1) {
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

            if (userInput == 0 && randomNumber == 2) {
                System.out.println("YOU WIN!!");
            } else if (userInput == 1 && randomNumber == 0) {
                System.out.println("YOU WIN!");
            } else if (userInput == 2 && randomNumber == 1) {
                System.out.println("YOU WIN!");
            } else if (userInput == randomNumber) {
                System.out.println("It`s a draw");
            } else {
                System.out.println("YOU LOST!");
            }
            System.out.println("************************");
        }
    }
}
