package se.yrgo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            // Skapa ett nytt spel

            // Metod för att få fram ett slumpat ord


            Player player1 = new Player(input);
            Player player2 = new Player(input);

            for (int i = 0; i < 3; i++) {
                String rndWord = WordGenerator.getWord("src/main/java/se/yrgo/wordlist.txt");
                Game game = new Game(player1, player2, rndWord);
                String winner = game.startGame();

                // Bäst av tre omgångar vinner?
                System.out.println("Spelet är över");
                System.out.printf("%s vann!", winner);
            }


            // Be om två spelarnamn
            // Skapa två spelare
            // spelare ska ha ett namn och poäng

            // Börja ett nytt spel



        } catch (IOException ex) {
            System.err.println("Something went wrong");
            ex.printStackTrace();
        }

    }
}