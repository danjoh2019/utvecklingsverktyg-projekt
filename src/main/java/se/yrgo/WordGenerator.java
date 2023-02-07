package se.yrgo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordGenerator {

    public static String getWord(String path) throws IOException {
        String word = null;
        List wordList = Files.readAllLines(Path.of(path));
        int rndNumber = ThreadLocalRandom.current().nextInt(1, wordList.size() + 1);

        for (int i = 0; i < rndNumber; i++) {
            word = wordList.get(i).toString();
        }

        return word;
    }
}
