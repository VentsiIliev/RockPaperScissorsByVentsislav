package RockPaperScissors;

public class Main {
    public static void main(String[] args) {

        System.out.printf("HOW MANY ROUNDS WOULD YOU LIKE TO PLAY (1 - %d)\n", Integer.MAX_VALUE);
        int roundsCount = RockPaperScissors.getValidInput(1, Integer.MAX_VALUE);
        for (int i = 0; i < roundsCount; i++) {
            RockPaperScissors.currentRound = 1;
            RockPaperScissors.startGame(roundsCount,RockPaperScissors.currentRound);
            RockPaperScissors.currentRound++;
        }

    }
}