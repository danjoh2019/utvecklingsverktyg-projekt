package se.yrgo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void testGetPlayerName() {
        Player player = new Player("kalle");
        assertEquals("kalle", player.getPlayerName());
    }

    @Test
    void testPlayerpoint() {

        Player player = new Player("kalle");
        int number = player.getPoint();
        player.addPoint();
        assertTrue(number < player.getPoint());


    }


    @Test
    void setPoint() {
    }
}