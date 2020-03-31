package com.company;

import java.util.*;

public class Game {
    private Board board;
    private int progressionLength;
    private boolean gameIsRunning;

    public Game(Board board, int length, Player pl1, Player pl2) {
        this.board = board;
        this.progressionLength = length;
        new Thread(pl1).start();
        new Thread(pl2).start();
    }

    public int getProgressionLength() {
        return progressionLength;
    }

    public void setProgressionLength(int progressionLength) {
        this.progressionLength = progressionLength;
    }

}
