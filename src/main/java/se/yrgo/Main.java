package se.yrgo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            // Skapa ett nytt spel
            System.out.println("╔═════════════╗");
            System.out.println("║ GISSA ORDET ║");
            System.out.println("╚═════════════╝");
            // Metod för att få fram ett slumpat ord

            System.out.printf("Vad heter spelare 1?: ");
            Player player1 = new Player(scanner.next());
            System.out.printf("Vad heter spelare 2?: ");
            Player player2 = new Player(scanner.next());


            for(int i = 0; i < 3; i++){
                String rndWord = WordGenerator.getWord("src/main/java/se/yrgo/wordlist.txt");
                Game game = new Game(player1,player2,rndWord);

                System.out.println("\nNy runda!\n");
                System.out.printf("Det hemliga ordet är %d bokstäver långt%n", rndWord.length());
                game.setRandomPlayer();
                while (game.isGameRunning()){
                    game.gameLoop();
                    game.guess(scanner.next());
                    game.switchPlayer();
                    System.out.println();
                }
}
                System.out.println("Omgången är över");
                if (player1.getPoint() > player2.getPoint()) {
                    System.out.println(player1.getPlayerName() + " vann!!!");
                } else {
                    System.out.println(player2.getPlayerName() + " vann!!!");
                }
            System.out.println("Tack för att du spelade!");

        } catch (IOException ex) {
            System.err.println("Something went wrong");
            ex.printStackTrace();
        }

    }
}