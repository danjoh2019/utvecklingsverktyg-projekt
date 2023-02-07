package se.yrgo;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("wordlist.txt");
        String rndWord = WordGenerator.getWord(path);

        System.out.println(rndWord);
    }
}