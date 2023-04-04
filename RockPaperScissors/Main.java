package RockPaperScissors;

public class Main {
    public static void main(String[] args) {
        RockPaperScissors playGame = new RockPaperScissors();

            RockPaperScissors.isException = true;
            do {
                try {
                    RockPaperScissors.askHowManyRounds();
                    RockPaperScissors.isException = false;
                } catch (Exception e) {
                    System.out.println("INVALID INPUT");
                    System.out.println("Please enter whole number grater than 0");
                }
            } while (RockPaperScissors.isException);

    }
}