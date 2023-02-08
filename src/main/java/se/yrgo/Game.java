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
        System.out.print("┌");

        for (int i = 0; i < randomWord.length() + 2; i++) {
            System.out.print("─");
        }

        System.out.println("┐");
        System.out.println("│ " + GetSecretWord() + " │");
        System.out.print("└");

        for (int i = 0; i < randomWord.length() + 2; i++) {
            System.out.print("─");
        }

        System.out.println("┘");

        System.out.println(currentPlayer.getPlayerName() + "! Gissa en bokstav eller hela ordet:");
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

    public void guess(String input) {
        String guess = input.toLowerCase();
        if (!(Character.isAlphabetic(guess.charAt(0)))) {
            System.out.println("Skriv en giltig bokstav!");
            System.out.println("Försök igen");
            switchPlayer();
        } else {
            if (guess.length() != randomWord.length()) {
                char guessedLetter = guess.charAt(0);
                if (!(guessedLetters.contains(guessedLetter))) {
                    guessedLetters.add(guessedLetter);
                    System.out.println("You guessed " + guessedLetter);
                    if (randomWord.equals(GetSecretWord())) {
                        win();
                    }
                } else {
                    System.out.println("Ni har redan gissat på: " + guessedLetter);
                    switchPlayer();
                    System.out.println();
                    System.out.println("Försök igen:");
                }

            } else if(guess.equals(randomWord)){
                win();
            }

        }


    }

    public void win() {
        System.out.println(currentPlayer.getPlayerName() + " win!");
        currentPlayer.setPoint(1);
        gameRunning = false;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void switchPlayer() {
        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

}
