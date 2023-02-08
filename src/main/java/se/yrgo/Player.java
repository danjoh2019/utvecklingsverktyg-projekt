package se.yrgo;

public class Player {
    private String name;

    private int point;

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

    void setPoint(int addpoint) {
        this.point += addpoint;
    }
}



