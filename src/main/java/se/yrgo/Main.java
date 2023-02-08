package se.yrgo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            // Skapa ett nytt spel

            // Metod för att få fram ett slumpat ord

            System.out.println("Vad heter spelare 1?");
            Player player1 = new Player(scanner.next());
            System.out.println("Vad heter spelare 2?");
            Player player2 = new Player(scanner.next());


            for(int i = 0; i < 3; i++){
                System.out.println();
                System.out.println("New game!");
                System.out.println();
                String rndWord = WordGenerator.getWord("src/main/java/se/yrgo/wordlist.txt");
                Game game = new Game(player1,player2,rndWord);
                game.setRandomPlayer();
                while (game.isGameRunning()){
                    game.gameLoop();
                    game.guess(scanner.next());
                    game.switchPlayer();
                    System.out.println();
                }
            }

        } catch (IOException ex) {
            System.err.println("Something went wrong");
            ex.printStackTrace();
        }

    }
}