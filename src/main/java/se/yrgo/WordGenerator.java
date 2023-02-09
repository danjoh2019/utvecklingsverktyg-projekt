package se.yrgo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class generates a random Swedish word from a list of words in a text file.
 */
public class WordGenerator {

    /**
     * A method that returns a random word as a String from the file in the given path.
     * @param path filepath to the file with all the words.
     */
    public static String getWord(String path) throws IOException {

        String word = null;
        List<String> wordList = Files.readAllLines(Path.of(path));
        int rndNumber = ThreadLocalRandom.current().nextInt(1, wordList.size() + 1);

        for (int i = 0; i < rndNumber; i++) {
            word = wordList.get(i);
        }

        return word;
    }
}
