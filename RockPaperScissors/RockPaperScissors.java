package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static Scanner scanner = new Scanner(System.in);
    public static int playerWins;
    public static int computerWins;
    public static int draws;
    public static String answer;
    public static boolean isException;
    public static int rounds;
    public static int currentRound = 1;

    public static void main(String[] args) {

        isException = true;
        do {
            try {
                askHowManyRounds();
                isException = false;
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                System.out.println("Please enter whole number grater than 0");
            }
        } while (isException);
    }

    public static void playRockPaperScissors() {

        // GIVE OPTIONS
        System.out.println("Choose wisely");
        System.out.println("[R]ock, [P]aper, [S]cissors");

        // GAME

        // GET INPUT
        // VALIDATE INPUT
        String playerInput = scanner.nextLine().toLowerCase();
        while (!"r".equals(playerInput) && !"p".equals(playerInput) && !"s".equals(playerInput)) {
            System.out.println("Invalid input.");
            System.out.println("[R]ock, [P]aper, [S]cissors");
            playerInput = scanner.nextLine().toLowerCase();
        }


        // PLAYER CHOISE
        String playerChoice = "";
        if ("r".equals(playerInput)) {
            playerChoice = "Rock";
        } else if ("p".equals(playerInput)) {
            playerChoice = "Paper";
        } else {
            playerChoice = "Scissors";
        }
        System.out.printf("--------- ROUND: %d ---------\n", currentRound);
        System.out.printf("You chose %s!\n", playerChoice);


        // COMPUTER CHOICE
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        String computerChoice = "";
        if (randomNumber == 0) {
            computerChoice = "Rock";
        } else if (randomNumber == 1) {
            computerChoice = "Paper";
        } else {
            computerChoice = "Scissors";
        }
        System.out.printf("The computer chose %s!\n", computerChoice);


        // ROUND OUTCOME OPTIONS
        if ("r".equals(playerInput) && randomNumber == 2) {
            playerWins++;
            System.out.println("YOU WIN!!");
        } else if ("p".equals(playerInput) && randomNumber == 0) {
            playerWins++;
            System.out.println("YOU WIN!");
        } else if ("s".equals(playerInput) && randomNumber == 1) {
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


        // STATS
        System.out.println("Stats");
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
                }
            }
        }
        askIfPlayerWantToPlayAgain();
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
        if (rounds == 1) {
            playRockPaperScissors();
        } else {
            for (int i = 1; i <= rounds; i++) {
                playRockPaperScissors();
                currentRound++;
            }
        }
    }

    public static void askIfPlayerWantToPlayAgain() {
        // ASK IF PLAYER WANTS TO PLAY AGAIN
        if (currentRound == rounds) {
            System.out.println("Do you want to start a new game? [Y]es [N]o");
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
            } else {
                System.exit(0);
            }
        }
    }
}