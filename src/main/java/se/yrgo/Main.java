package se.yrgo;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        try {
            String rndWord = WordGenerator.getWord("src/main/java/se/yrgo/wordlist.txt");

            System.out.println(rndWord);

        } catch (IOException ex) {
            System.err.println("Something went wrong");
            ex.printStackTrace();
        }

    }
}