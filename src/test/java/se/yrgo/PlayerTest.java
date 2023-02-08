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
        try {
           // Player addpoint = new Player("gg");
        }
       // catch ()

        }


    @Test
    void setPoint() {
    }
}