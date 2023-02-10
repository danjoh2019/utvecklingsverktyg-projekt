package se.yrgo;

/**
 * Her we input the player's name  and generate points to the players.
 */
public class Player {

    private final String name;

    private int point;

    /**
     *
     *
     * @param player
     */
    public Player(String player) {
        this.name = player;
        this.point = 0;
    }


    public String getPlayerName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    void addPoint() {
        this.point += 1;
    }
}



