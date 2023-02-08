package se.yrgo;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testGetSecretWord() throws IOException {
        String text = WordGenerator.getWord("src/main/java/se/yrgo/wordlist.txt");
        Game game = new Game(new Player("player1"), new Player("player2"), text);
        assertEquals(text.length(), game.GetSecretWord().length());
    }

    @Test
    public void testSwitchPlayer(){
        Player test1 = new Player("player1");
        Player test2 = new Player("player2");
        Game game = new Game(test1,test2, "text");
        game.setRandomPlayer(); // Set the current player to one of the two players
        Player oldPlayer = game.getCurrentPlayer();
        game.switchPlayer();
        Player newPlayer = game.getCurrentPlayer();
        assertNotEquals(oldPlayer,newPlayer);

    }

}