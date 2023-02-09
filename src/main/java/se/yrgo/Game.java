package se.yrgo;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is responsible for the game functions
 */
public class Game {
    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;
    private final String randomWord;
    private List<Character> guessedLetters;
    private List<Character> usedLetters = new ArrayList<>();
    private boolean gameRunning;

    /**
     *
     * @param playerOne One of the players
     * @param playerTwo The other player
     * @param randomWord The secret word that the players will try to guess
     */
    public Game(Player playerOne, Player playerTwo, String randomWord) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.randomWord = randomWord;
        this.guessedLetters = new ArrayList<>();
        this.gameRunning = true;
    }

    /**
     * Randomizes the currentPlayer, used when starting a game
     */
    public void setRandomPlayer() {

        if (ThreadLocalRandom.current().nextBoolean()) {
            currentPlayer = playerOne;
        } else {
            currentPlayer = playerTwo;
        }
    }

    /**
     * The main gameloop that shows the current status of the game
     */
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
        System.out.println("Använda bokstäver: " + usedLetters.toString());
        System.out.print(currentPlayer.getPlayerName() + ", gissa en bokstav eller hela ordet: ");
    }

    /**
     * @return A player object that represent the current player
     */
    public Player getCurrentPlayer(){

        return currentPlayer;
    }

    /**
     * This function is used to get the secret word, but only show the letters that the players have guessed
     */
    public String GetSecretWord() {

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

    /**
     * This function handles the guess of the players
     * It checks if the player tried to guess the entire word by comparing
     * the length of the guess with the length of the secret word.
     * If the player did not try to guess the entire word, it checks if the first
     * letter in the word with:
     * 1. The list containing all the guessed letters
     * 2. If the secret word contains the letter
     */
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

                    if (!randomWord.contains(Character.toString(guessedLetter))) {
                        usedLetters.add(guessedLetter);
                    }

                    System.out.println("Du gissade på: " + guessedLetter);

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

    /**
     * Adds a point to the current player
     * Sets gameRunning to false
     */
    public void win() {

        System.out.println(currentPlayer.getPlayerName() + " gissade rätt!");
        System.out.println("Rätt ord var: " + randomWord);
        currentPlayer.addPoint();
        gameRunning = false;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Switches the currentPlayer
     */
    public void switchPlayer() {
        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

}
