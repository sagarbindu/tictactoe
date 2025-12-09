package com.example.boardgame.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random random = new Random();

    public ComputerPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public int[] getMove(Board board) {
        System.out.println(getName() + " (" + getMark() + ") is thinking...");

        // Try to win
        int[] winMove = findWinningMove(board, getMark());
        if (winMove != null) {
            return winMove;
        }

        // Try to block opponent
        char opponentMark = (getMark() == 'X') ? 'O' : 'X';
        int[] blockMove = findWinningMove(board, opponentMark);
        if (blockMove != null) {
            return blockMove;
        }

        // Otherwise random move
        List<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.isCellEmpty(i, j)) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        if (emptyCells.isEmpty()) {
            return new int[]{0, 0}; // should not happen if called correctly
        }

        return emptyCells.get(random.nextInt(emptyCells.size()));
    }

    private int[] findWinningMove(Board board, char mark) {
        char[][] grid = board.getGridCopy();
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = mark;
                    if (isWinner(grid, mark)) {
                        return new int[]{i, j};
                    }
                    grid[i][j] = ' ';
                }
            }
        }
        return null;
    }

    private boolean isWinner(char[][] grid, char mark) {
        // rows
        for (int i = 0; i < Board.SIZE; i++) {
            if (grid[i][0] == mark && grid[i][1] == mark && grid[i][2] == mark) {
                return true;
            }
        }
        // cols
        for (int j = 0; j < Board.SIZE; j++) {
            if (grid[0][j] == mark && grid[1][j] == mark && grid[2][j] == mark) {
                return true;
            }
        }
        // diagonals
        if (grid[0][0] == mark && grid[1][1] == mark && grid[2][2] == mark) {
            return true;
        }
        if (grid[0][2] == mark && grid[1][1] == mark && grid[2][0] == mark) {
            return true;
        }
        return false;
    }
}
