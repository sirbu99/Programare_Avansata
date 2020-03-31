package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.yield;

public class Player implements Runnable {
    private String name;
    private Board board;
    private Game game;
    private List<Integer> arithmeticProgression = new ArrayList<Integer>();

    public Player(String name) {
        this.name = name;
    }

    private void extractToken() throws Exception {
        Random rand = new Random();
        int index = board.getTokenList().size();
        arithmeticProgression.add(board.getTokenList().get(rand.nextInt(index)).getValue());
        board.deleteToken(board.getTokenList().get(rand.nextInt(index)));
    }

    private boolean isProgression() {
        Collections.sort(arithmeticProgression);
        int commonDifference = Math.abs(arithmeticProgression.get(0) - arithmeticProgression.get(1));
        if (arithmeticProgression.size() != game.getProgressionLength()) {
            return false;
        } else {
            for (int i = 0; i < game.getProgressionLength() - 1; i++) {
                if (Math.abs(arithmeticProgression.get(i) - arithmeticProgression.get(i + 1)) != commonDifference) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "Lista aleasa : " + arithmeticProgression;
    }

    @Override
    public void run() {
        try {
            extractToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
