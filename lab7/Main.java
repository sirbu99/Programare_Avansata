package com.company;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Jucator1");
        Player player2 = new Player("Jucator2");
        Board board = new Board(10);
        Game game = new Game(board, 5, player1, player2);
    }
}
