package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static Scanner scanner = new Scanner(System.in);
    static int playerWins;
    static int computerWins;
    static int draws;
    static String answer;
    static boolean isException;
    static int rounds;
    static int currentRound = 1;


    public static void playRockPaperScissors() {

        // PRINT MOVE OPTIONS
        System.out.println("Choose wisely");
        System.out.println("[R]ock, [P]aper, [S]cissors");

        // GAME

        // GET PLAYER CHOICE
        // VALIDATE INPUT
        String playerChoice = scanner.nextLine().toLowerCase();
        while (!"r".equals(playerChoice) && !"p".equals(playerChoice) && !"s".equals(playerChoice)) {
            System.out.println("Invalid input.");
            System.out.println("[R]ock, [P]aper, [S]cissors");
            playerChoice = scanner.nextLine().toLowerCase();
        }


        // PRINT PLAYER CHOICE
        if ("r".equals(playerChoice)) {
            playerChoice = "Rock";
        } else if ("p".equals(playerChoice)) {
            playerChoice = "Paper";
        } else {
            playerChoice = "Scissors";
        }
        System.out.printf("--------- ROUND: %d ---------\n", currentRound);
        System.out.printf("You chose %s!\n", playerChoice);


        // GET COMPUTER CHOICE
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        // PRINT COMPUTER CHOICE
        String computerChoice = "";
        if (randomNumber == 0) {
            computerChoice = "Rock";
        } else if (randomNumber == 1) {
            computerChoice = "Paper";
        } else {
            computerChoice = "Scissors";
        }
        System.out.printf("The computer chose %s!\n", computerChoice);


        // DETERMINE AND PRINT ROUND OUTCOME
        if ("Rock".equals(playerChoice) && randomNumber == 2) {
            playerWins++;
            System.out.println("YOU WIN!!");
        } else if ("Paper".equals(playerChoice) && randomNumber == 0) {
            playerWins++;
            System.out.println("YOU WIN!");
        } else if ("Scissors".equals(playerChoice) && randomNumber == 1) {
            playerWins++;
            System.out.println("YOU WIN!");
        } else if (playerChoice.equals(computerChoice)) {
            draws++;
            System.out.println("It`s a draw");
        } else {
            computerWins++;
            System.out.println("YOU LOST!");
        }
        System.out.println("----------------------------");


        // SCORE
        System.out.println("Score");
        System.out.printf("You %d : %d Computer\n", playerWins, computerWins);

        if (draws > 0) {
            System.out.printf("Draws: %d\n", draws);
        }

        // TIE BREAK
        // VALIDATE INPUT
        if (currentRound == rounds) {
            if (computerWins == playerWins) {
                System.out.println("It`s a tie. Do you want to play tie break rounds? [Y]es [N]o");
                answer = scanner.nextLine().toUpperCase();
                while (!"Y".equals(answer) && !"N".equals(answer)) {
                    System.out.println("INVALID INPUT");
                    System.out.println("[Y]es [N]o");
                    answer = scanner.nextLine().toUpperCase();
                }
                if ("Y".equals(answer)) {
                    while (computerWins == playerWins) {
                        playRockPaperScissors();
                    }
                } else {
                    askIfPlayerWantToPlayAgain();
                    startGame();
                }
            }
        }

        // ASK IF PLAYER WANTS TO PLAY AGAIN
        if (currentRound == rounds) {
            System.out.println("Do you want to start a New Game? [Y]es [N]o");
            answer = scanner.nextLine().toUpperCase();
            while (!"Y".equals(answer) && !"N".equals(answer)) {
                System.out.println("INVALID INPUT");
                System.out.println("[Y]es [N]o");
                answer = scanner.nextLine().toUpperCase();
            }
            if ("Y".equals(answer)) {
                currentRound = 1;
                computerWins = 0;
                playerWins = 0;
                draws = 0;
                askHowManyRounds();
                startGame();
            } else {
                System.exit(0);
            }
        }
    }

    // ASK PLAYER HOW MANY ROUND TO PLAY
    // VALIDATE INPUT
    public static void askHowManyRounds() {
        System.out.println("How many rounds would you like to play?");
        rounds = Integer.parseInt(scanner.nextLine());
        while (rounds <= 0) {
            System.out.println("Please enter whole number grater than 0!");
            rounds = Integer.parseInt(scanner.nextLine());
        }
    }

    public static void startGame() {
        // START GAME
        for (int i = 1; i <= rounds; i++) {
            playRockPaperScissors();
            currentRound++;
        }
    }

    public static void askIfPlayerWantToPlayAgain() {

    }
}