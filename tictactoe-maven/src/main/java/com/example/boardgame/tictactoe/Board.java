package com.example.boardgame.tictactoe;

import java.util.Arrays;

public class Board {
    private final char[][] grid;
    public static final int SIZE = 3;
    private static final char EMPTY = ' ';

    public Board() {
        grid = new char[SIZE][SIZE];
        reset();
    }

    public void reset() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(grid[i], EMPTY);
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == EMPTY;
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false;
        }
        if (!isCellEmpty(row, col)) {
            return false;
        }
        grid[row][col] = mark;
        return true;
    }

    public boolean hasWinner(char mark) {
        // rows
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] == mark && grid[i][1] == mark && grid[i][2] == mark) {
                return true;
            }
        }
        // cols
        for (int j = 0; j < SIZE; j++) {
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

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getGridCopy() {
        char[][] copy = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, SIZE);
        }
        return copy;
    }

    public void print() {
        System.out.println();
        System.out.println("   1   2   3");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                char c = grid[i][j];
                if (c == EMPTY) {
                    c = '.';
                }
                System.out.print(" " + c + " ");
                if (j < SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("  ---+---+---");
            }
        }
        System.out.println();
    }
}
