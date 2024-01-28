package task1;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class TicTacToeGame 
{
	    public static void main(String[] args) {
	        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
	        char currentPlayer = 'X';
	        boolean gameWon = false;

	        Scanner scanner = new Scanner(System.in);

	        while (!gameWon) {
	            printBoard(board);
	            int[] move = getMove(scanner, currentPlayer);
	            int row = move[0];
	            int col = move[1];

	            if (isValidMove(board, row, col)) {
	                board[row][col] = currentPlayer;

	                if (checkWin(board, currentPlayer)) {
	                    gameWon = true;
	                    printBoard(board);
	                    System.out.println(currentPlayer + " wins!");
	                } else if (isBoardFull(board)) {
	                    gameWon = true;
	                    printBoard(board);
	                    System.out.println("It's a draw!");
	                } else {
	                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	                }
	            } else {
	                System.out.println("Invalid move! Try again.");
	            }
	        }

	        scanner.close();
	    }

	    private static void printBoard(char[][] board) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j]);
	                if (j < 2) {
	                    System.out.print(" | ");
	                }
	            }
	            System.out.println();
	            if (i < 2) {
	                System.out.println("---------");
	            }
	        }
	    }

	    private static int[] getMove(Scanner scanner, char currentPlayer) {
	        int[] move = new int[2];
	        System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
	        move[0] = scanner.nextInt();
	        move[1] = scanner.nextInt();
	        return move;
	    }

	    private static boolean isValidMove(char[][] board, int row, int col) {
	        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
	    }

	    private static boolean checkWin(char[][] board, char player) {
	        // Check rows, columns, and diagonals
	        for (int i = 0; i < 3; i++) {
	            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
	                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
	                return true;
	            }
	        }
	        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
	                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
	    }

	    private static boolean isBoardFull(char[][] board) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == ' ') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	
private static void saveGame(char[][] board, char currentPlayer) {
    try (FileWriter writer = new FileWriter("tictactoe_save.txt")) {
        writer.write(currentPlayer + "\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                writer.write(board[i][j]);
            }
            writer.write("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void loadGame(char[][] board) {
    try (BufferedReader reader = new BufferedReader(new FileReader("tictactoe_save.txt"))) {
        char currentPlayer = reader.readLine().charAt(0);
        for (int i = 0; i < 3; i++) {
            String line = reader.readLine();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
