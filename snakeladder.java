
import java.util.Random;
import java.util.Scanner;

public class snakeladder {

    static int validplayer(Scanner sc, String message) {
        int number;
        while (true) {
            System.out.println(message);
            String input = sc.nextLine();
            try {
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }

        }
        return number;

    }

    static String getplayername(Scanner sc, String message) {
        String playerName;
        while (true) {
            System.out.println(message);
            playerName = sc.nextLine();
            if (!playerName.isEmpty() && !containsNumber(playerName)) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        return playerName;

    }

    static boolean containsNumber(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    static int diceRoll() {
        Random random = new Random();
        int randomnumber = random.nextInt(6) + 1;
        return randomnumber;

    }

    public static void main(String[] args) {
        int participant;
        int[] player;
        String[] playerNames;

        System.out.println("");
        try (Scanner sc = new Scanner(System.in)) {
            participant = validplayer(sc, "Enter the number of players");
            player = new int[participant];
            playerNames = new String[participant];

            for (int i = 0; i < participant; i++) {
                playerNames[i] = getplayername(sc, "Enter player name for player" + (i + 1));
                player[i] = i + 1;
            }

            int target = 100;
            int currentplayer = 0;
            int relavantposition = 1;
            String input;
            while (true) {
                System.out.println(playerNames[currentplayer] + " " + "Press enter to roll dice..");
                input = sc.nextLine();

                if (input.isEmpty()) {
                    int dicevalue = diceRoll();
                    System.out.println(playerNames[currentplayer] + " " + "rolled" + dicevalue);

                    relavantposition+=dicevalue;

                    System.out.println(playerNames[currentplayer] + "is at" + relavantposition);

                    if(relavantposition>=target){
                        System.out.println(playerNames[currentplayer]+"wins!!");
                        break;
                    }

                    currentplayer = (currentplayer + 1) % participant;
                }

                else {
                    System.out.println("Invalid");
                }
            }

        }

    }
}
