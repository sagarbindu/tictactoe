package com.example.boardgame.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;

    public HumanPlayer(String name, char mark, Scanner scanner) {
        super(name, mark);
        this.scanner = scanner;
    }

    @Override
    public int[] getMove(Board board) {
        while (true) {
            System.out.print(getName() + " (" + getMark() + "), enter row and column (1-3 1-3): ");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                // consume remaining line
                scanner.nextLine();

                row -= 1;
                col -= 1;

                if (row < 0 || row >= Board.SIZE || col < 0 || col >= Board.SIZE) {
                    System.out.println("Coordinates out of range. Try again.");
                    continue;
                }
                if (!board.isCellEmpty(row, col)) {
                    System.out.println("Cell is already occupied. Try again.");
                    continue;
                }
                return new int[]{row, col};
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter two numbers like: 1 3");
                scanner.nextLine(); // clear invalid input
            }
        }
    }
}
