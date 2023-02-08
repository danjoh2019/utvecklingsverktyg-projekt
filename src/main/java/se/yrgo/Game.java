package se.yrgo;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private boolean running;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private Path RANDOM_WORD_LIST;
    private String randomWord;
    private List<Character> guessedLetters;
    private boolean gameRunning;


    public Game(Player playerOne, Player playerTwo, String randomWord) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.randomWord = randomWord;
        this.guessedLetters = new ArrayList<>();
        this.gameRunning = true;
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
        System.out.println(currentPlayer.getPlayerName() + "! Guess a letter or the entire word:");
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
        System.out.println(randomWord);

        if (guess.length() != randomWord.length()) {
            char guessedLetter = guess.charAt(0);

            System.out.println(guessedLetters);

            if(!(guessedLetters.contains(guessedLetter))){
                guessedLetters.add(guessedLetter);
                System.out.println("You guessed " + guessedLetter);
            }
            else{
                System.out.println("You have already guessed " + guessedLetter);
            }


        }
        else{
            System.out.println(currentPlayer.getPlayerName() + " win!");
            currentPlayer.setPoint(1);
            gameRunning = false;
        }


    }

    public boolean gameRunning(){
        return gameRunning();
    }

    public void switchPlayer() {
        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

}
