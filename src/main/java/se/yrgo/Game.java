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
    private List<Character> guessedLetters;


    public Game(Player playerOne, Player playerTwo, String randomWord){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.RANDOM_WORD_LIST = RANDOM_WORD_LIST;
        this.randomWord = randomWord;
    }

    public Player startGame() throws IOException {
        running = true;
        while(running){
            randomWord = WordGenerator.getWord(RANDOM_WORD_LIST.toString());
            if(ThreadLocalRandom.current().nextBoolean()){
                currentPlayer = playerOne;
            }
            else {
                currentPlayer = playerTwo;
            }
            System.out.println(GetSecretWord());
            System.out.println(currentPlayer.getPlayer + "! Guess a letter or the entire word:");
            String guess = scanner.next();
            Guess(guess);
        }

    }

    private String GetSecretWord() {
        String output = "";
        for (int i = 0; i < randomWord.length(); i++){
            if(guessedLetters.contains(randomWord.charAt(i))){
                output += randomWord.charAt(i);
            }
            else {
                output += "_";
            }
        }
        return output;
    }

    private void Guess(String guess) {
        if(guess.length() != randomWord.length()){
            String guessedLetter = Character.toString(guess.charAt(0));
            if(randomWord.contains(guessedLetter) && !(guessedLetters.contains(guessedLetter))){
                guessedLetters.add(guessedLetter.charAt(0));
            }
            else{
                // invalid guess
            }
        }
        else{
            if(guess.equals(randomWord)){
                win(currentPlayer);
            }
        }
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
