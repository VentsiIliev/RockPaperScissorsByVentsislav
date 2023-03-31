package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static int playerWins;
    public static int computerWins;
    public static int draws;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isException = true;
        do {
            try {
                // ASK USER HOW MANY ROUND TO PLAY
                System.out.println("How many rounds would you like to play?");
                int rounds = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < rounds; i++) {
                    playRockPaperScissors();
                    // TIE BREAK
                    if (RockPaperScissors.computerWins == RockPaperScissors.playerWins) {
                        System.out.println("It`s a tie. Do you want to play tie break rounds? [Y][N]");
                        String answer = scanner.nextLine().toUpperCase();
                        if ("Y".equals(answer)) {
                            while (computerWins == playerWins) {
                                playRockPaperScissors();
                            }
                        }
                    }
                    isException = false;
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                System.out.println("Please enter whole number grater than 0");
            }

        } while (isException);
    }

    public static void playRockPaperScissors() {
        Scanner scanner = new Scanner(System.in);

        // GIVE MOVE OPTIONS
        System.out.println("Choose wisely");
        System.out.println("[r]ock");
        System.out.println("[p]aper");
        System.out.println("[s]cissors");

        // GAME
        String userInput = scanner.nextLine();
        // VALIDATE INPUT
        while (!"r".equals(userInput) && !"p".equals(userInput) && !"s".equals(userInput)) {
            System.out.println("Invalid input.");
            System.out.println("Please enter a valid number ([r]ock, [p]aper, [s]cissors).");
            userInput = scanner.nextLine();
        }
        // PLAYER MOVE
        String userChoice = "";
        if ("r".equals(userInput)) {
            userChoice = "Rock";
        } else if ("p".equals(userInput)) {
            userChoice = "Paper";
        } else {
            userChoice = "Scissors";
        }

        System.out.printf("You chose %s!\n", userChoice);
        // COMPUTER MOVE
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
        // ROUND OUTCOME
        if ("r".equals(userInput) && randomNumber == 2) {
            RockPaperScissors.playerWins++;
            System.out.println("YOU WIN!!");
        } else if ("p".equals(userInput) && randomNumber == 0) {
            RockPaperScissors.playerWins++;
            System.out.println("YOU WIN!");
        } else if ("s".equals(userInput) && randomNumber == 1) {
            RockPaperScissors.playerWins++;
            System.out.println("YOU WIN!");
        } else if (userChoice.equals(computerMove)) {
            RockPaperScissors.draws++;
            System.out.println("It`s a draw");
        } else {
            RockPaperScissors.computerWins++;
            System.out.println("YOU LOST!");
        }
        System.out.println("************************");

        // STATS
        System.out.println("Stats");
        System.out.printf("You %d : %d Computer\n", RockPaperScissors.playerWins, RockPaperScissors.computerWins);

        if (RockPaperScissors.draws > 0) {
            System.out.printf("Draws: %d\n", RockPaperScissors.draws);
        }
    }
}

