package com.example.boardgame.tictactoe;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        board.reset();
        Player current = player1;

        while (true) {
            board.print();
            int[] move = current.getMove(board);
            board.placeMark(move[0], move[1], current.getMark());

            if (board.hasWinner(current.getMark())) {
                board.print();
                System.out.println("🎉 " + current.getName() + " (" + current.getMark() + ") wins!");
                break;
            }

            if (board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
                break;
            }

            current = (current == player1) ? player2 : player1;
        }
    }
}
