package se.yrgo;

public class Player {
    private String player;

    private int point;

    public Player(String player) {
        this.player = player;
        this.point = 0;
    }

    public String getPlayer() {
        return player;
    }

    public int getPoint() {
        return point;
    }

    void setPoint(int addpoint) {
        this.point += addpoint;
    }
}



