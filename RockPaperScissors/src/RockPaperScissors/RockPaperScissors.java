package RockPaperScissors;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static Scanner scanner = new Scanner(System.in);
    static int playerWins;
    static int computerWins;
    static int draws;
    static int currentRound;

    public static void printMoveOptions() {
        // PRINT MOVE OPTIONS
        System.out.println("Choose wisely");
        System.out.println("[R]ock, [P]aper, [S]cissors");
    }

    public static String getPlayerInput() {
        // PRINT MOVE OPTIONS
        // GET PLAYER INPUT
        return getValidInput("r", "p", "s");
    }

    public static String getPlayerChoice(String playerInput) {
        // GET PLAYER CHOICE
        String playerChoice = "";
        if ("r".equals(playerInput)) {
            playerChoice = "Rock";
        } else if ("p".equals(playerInput)) {
            playerChoice = "Paper";
        } else {
            playerChoice = "Scissors";
        }
        return playerChoice;
    }

    public static String getComputerChoice() {
        // GET COMPUTER CHOICE
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        HashMap<Integer, String> computerChoiceHashMap = new HashMap<>();
        computerChoiceHashMap.put(0, "Rock");
        computerChoiceHashMap.put(1, "Paper");
        computerChoiceHashMap.put(2, "Scissors");

        String computerChoice = "";
        for (Map.Entry<Integer, String> entry : computerChoiceHashMap.entrySet()) {
            if (entry.getKey() == randomNumber) {
                computerChoice = entry.getValue();
            }
        }
        return computerChoice;
    }

    public static String getRoundResult(String playerChoice, String computerChoice) {
        // DETERMINE OUTCOME
        String roundResult = "";
        if ("Rock".equals(playerChoice) && "Scissors".equals(computerChoice)) {
            roundResult = "YOU WIN!";
        } else if ("Paper".equals(playerChoice) && "Rock".equals(computerChoice)) {
            roundResult = "YOU WIN!";
        } else if ("Scissors".equals(playerChoice) && "Paper".equals(computerChoice)) {
            roundResult = "YOU WIN!";
        } else if (playerChoice.equals(computerChoice)) {
            roundResult = "IT`S A DRAW";
        } else {
            roundResult = "YOU LOST!";
        }
        return roundResult;
    }

    public static void updateScore(String roundResult) {
        if (roundResult.equalsIgnoreCase("you win!")) {
            playerWins++;
        } else if (roundResult.equalsIgnoreCase("you lost!")) {
            computerWins++;
        } else {
            draws++;
        }
    }

    public static void printScore(String playerChoice, String computerChoice, String roundResult) {

        System.out.println("-----------Round " + currentRound + "-----------");
        System.out.println("You chose " + playerChoice);
        System.out.println("Computer chose " + computerChoice);
        System.out.println(roundResult);
        System.out.println("-----------Score-----------");
        System.out.printf("You %d : %d Computer\n", playerWins, computerWins);

        if (draws > 0) {
            System.out.printf("Draws: %d\n", draws);
            System.out.println("----------------------------");
        } else {
            System.out.println("-------------------------");
        }
    }

    public static void startGame(int roundsCount, int currentRound) {
        printMoveOptions();
        String playerInput = getPlayerInput();
        String playerChoice = getPlayerChoice(playerInput);
        String computerChoice = getComputerChoice();
        String roundResult = getRoundResult(playerChoice, computerChoice);
        updateScore(roundResult);
        printScore(playerChoice, computerChoice, roundResult);

        // PLAY TIE BREAK - START NEW GAME - EXIT
        if (currentRound == roundsCount && playerWins == computerWins) {
            System.out.println("It`s a tie. Do you want to play tie break rounds? [Y]es [N]o");
            playTieBreak(roundsCount, RockPaperScissors.currentRound);
        } else if (currentRound == roundsCount) {
            restartOrExit(roundsCount);
        }
    }

    public static int getValidInput(int lowLimit, int highLimit) {
        boolean isInputValid = false;
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input < lowLimit || input > highLimit) {
                    System.out.println("Invalid Input");
                } else {
                    isInputValid = true;
                    return input;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    public static String getValidInput(String optionOne, String optionTwo, String optionThree) {
        String playerInput = scanner.nextLine();
        while (!optionOne.equalsIgnoreCase(playerInput) && !optionTwo.equalsIgnoreCase(playerInput) && !optionThree.equalsIgnoreCase(playerInput)) {
            System.out.println("Invalid input.");
            System.out.println("[R]ock, [P]aper, [S]cissors");
            playerInput = scanner.nextLine().toLowerCase();
        }
        return playerInput;
    }

    public static String getValidInput(String optionOne, String optionTwo) {
        String playerInput = scanner.nextLine();
        while (!optionOne.equalsIgnoreCase(playerInput) && !optionTwo.equalsIgnoreCase(playerInput)) {
            System.out.println("Invalid input.");
            playerInput = scanner.nextLine().toLowerCase();
        }
        return playerInput;
    }


    public static void restartOrExit(int roundsCount) {
        System.out.println("[S]TART NEW GAME");
        System.out.println("[E]XIT");
        String answer = getValidInput("s", "e");
        if (answer.equalsIgnoreCase("s")) {
            resetScore();
            startNewGame(roundsCount, RockPaperScissors.currentRound);
        } else {
            System.exit(0);
        }
    }

    public static void playTieBreak(int roundsCount, int currentRound) {

        String answer = getValidInput("y", "n");
        if ("Y".equalsIgnoreCase(answer)) {
            while (computerWins == playerWins) {
                currentRound++;
                printMoveOptions();
                String playerInput = getValidInput("r","p","s");
                String playerChoice = getPlayerChoice(playerInput);
                String computerChoice = getComputerChoice();
                String roundResult = getRoundResult(playerChoice,computerChoice);
                updateScore(roundResult);
                printScore(playerChoice,computerChoice, roundResult);
            }
            restartOrExit(roundsCount);
        } else {
            restartOrExit(roundsCount);
        }
    }

    public static void resetScore() {
        playerWins = 0;
        computerWins = 0;
        draws = 0;
        currentRound = 1;
    }

    public static void startNewGame(int roundsCount, int currentRound) {
        System.out.printf("HOW MANY ROUNDS WOULD YOU LIKE TO PLAY (1 - %d)\n", Integer.MAX_VALUE);
        roundsCount = getValidInput(1, Integer.MAX_VALUE);
        for (int i = 0; i < roundsCount; i++) {
            startGame(roundsCount, RockPaperScissors.currentRound);
            RockPaperScissors.currentRound++;
        }
    }
}
