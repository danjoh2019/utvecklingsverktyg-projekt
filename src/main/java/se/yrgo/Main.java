package se.yrgo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            // Skapa ett nytt spel

            // Metod för att få fram ett slumpat ord
            String rndWord = WordGenerator.getWord("src/main/java/se/yrgo/wordlist.txt");
            System.out.println(rndWord);

            // Be om två spelarnamn
            // Skapa två spelare

            // Börja ett nytt spel

            // Bäst av tre omgångar vinner?

        } catch (IOException ex) {
            System.err.println("Something went wrong");
            ex.printStackTrace();
        }

    }
}