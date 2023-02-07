package se.yrgo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private boolean running;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private Path RANDOM_WORD_LIST;
    private String randomWord;
    private Scanner scanner;
    private List<Character> guessedLetters;


    public Game(Player playerOne, Player playerTwo, Path RANDOM_WORD_LIST, Scanner scanner){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.RANDOM_WORD_LIST = RANDOM_WORD_LIST;
        this.scanner = scanner;
    }

    public void startGame(Path RANDOM_WORD_LIST) throws IOException {
        running = true;
        while(running){
            randomWord = WordGenerator.getWord(RANDOM_WORD_LIST.toString());
            if(ThreadLocalRandom.current().nextBoolean()){
                currentPlayer = playerOne;
            }
            else {
                currentPlayer = playerTwo;
            }
            DrawGame();
            System.out.println(currentPlayer.getName + "! Guess a letter or the entire word:");
            String guess = scanner.next();
            Guess(guess);
        }

    }

    private void DrawGame() {
        for (int i = 0; i < )
    }

    private void Guess(String guess) {

    }

    private void switchPlayer(){
        if (currentPlayer.equals(playerOne)){
            currentPlayer = playerTwo;
        }
        else{
            currentPlayer = playerOne;
        }
    }

}
