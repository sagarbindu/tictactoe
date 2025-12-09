package com.example.boardgame.tictactoe;

import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Tic Tac Toe (Java Console Board Game) ====");

        boolean playAgain;
        do {
            int mode = askGameMode(scanner);
            Board board = new Board();

            Player player1;
            Player player2;

            if (mode == 1) {
                System.out.print("Enter name for Player 1 (X): ");
                String name1 = scanner.nextLine().trim();
                if (name1.isEmpty()) {
                    name1 = "Player 1";
                }

                System.out.print("Enter name for Player 2 (O): ");
                String name2 = scanner.nextLine().trim();
                if (name2.isEmpty()) {
                    name2 = "Player 2";
                }

                player1 = new HumanPlayer(name1, 'X', scanner);
                player2 = new HumanPlayer(name2, 'O', scanner);
            } else {
                System.out.print("Enter your name (you will be X): ");
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    name = "You";
                }
                player1 = new HumanPlayer(name, 'X', scanner);
                player2 = new ComputerPlayer("Computer", 'O');
            }

            Game game = new Game(board, player1, player2);
            game.play();

            playAgain = askPlayAgain(scanner);
        } while (playAgain);

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }

    private static int askGameMode(Scanner scanner) {
        while (true) {
            System.out.println("Select mode:");
            System.out.println("1) Player vs Player");
            System.out.println("2) Player vs Computer");
            System.out.print("Enter choice (1 or 2): ");
            String line = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(line);
                if (choice == 1 || choice == 2) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    private static boolean askPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Play again? (y/n): ");
            String line = scanner.nextLine().trim().toLowerCase();
            if (line.equals("y") || line.equals("yes")) {
                return true;
            } else if (line.equals("n") || line.equals("no")) {
                return false;
            }
            System.out.println("Please answer with y or n.");
        }
    }
}
