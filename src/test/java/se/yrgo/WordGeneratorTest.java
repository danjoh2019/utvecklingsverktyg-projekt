package se.yrgo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WordGeneratorTest {

    @Test
    public void testNonExistingFilename() {
        try {
            WordGenerator.getWord("errorfile.txt");
            fail("NoSuchFileException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    @Test
    public void testGetWord() {
        try {
            String word = WordGenerator.getWord("src/main/java/se/yrgo/wordlist.txt");
            String allWord = Files.readString(Path.of("src/main/java/se/yrgo/wordlist.txt"));

            assertTrue(allWord.contains(word));
        } catch (IOException ex) {
            System.out.println("IOException");
        }

    }

}