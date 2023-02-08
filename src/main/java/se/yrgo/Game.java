package se.yrgo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
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
    private List<Character> guessedLetters;


    public Game(Player playerOne, Player playerTwo, String randomWord) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.randomWord = randomWord;
        this.guessedLetters = new ArrayList<>();
    }

    public void setRandomPlayer() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            currentPlayer = playerOne;
        } else {
            currentPlayer = playerTwo;
        }
    }

    public void gameLoop() {
        System.out.println(GetSecretWord());
        System.out.println(currentPlayer.getPlayer() + "! Guess a letter or the entire word:");
    }


    private String GetSecretWord() {
        String output = "";
        for (int i = 0; i < randomWord.length(); i++) {
            if (guessedLetters.contains(randomWord.charAt(i))) {
                output += randomWord.charAt(i);
            } else {
                output += "_";
            }
        }
        return output;
    }

    public void guess(String guess) {

        if (guess.length() != randomWord.length()) {
            String guessedLetter = Character.toString(guess.charAt(0));
            if (randomWord.contains(guessedLetter) && !(guessedLetters.contains(guessedLetter))) {
                guessedLetters.add(guessedLetter.charAt(0));
                System.out.println("You guessed " + guessedLetter);
            } else {
                System.out.println("Invalid guess, try again!");
            }
        } else {
            if (guess.equals(randomWord)) {
                //win(currentPlayer);
            }
        }


    }

    public void switchPlayer() {
        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

}
