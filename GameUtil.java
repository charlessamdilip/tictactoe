import java.util.Random;
import java.util.Scanner;

public class GameUtil {
  
  public GameUtil() {
  }
 
  // Initializes the board to the initial stage
  public static void initBoard (char[][] board) {
    for (int i = 0; i  < 3; ++i) {
      for (int j =0; j < 3; ++j) {
        board[i][j] = '-';
      }
    }
  }

  // Prints the board
  public static void printBoard (char[][] board) {
    System.out.println("Current Board : ");

    for (int i = 0; i  < 3; ++i) {
      for (int j =0; j < 3; ++j) {
        System.out.print(board[i][j] + "\t");
      }
      System.out.println("");
    }
  }
  
  // check is there a winner
  public static char checkWinner(char[][] board) {
    int[] cols = new int[3];
    int[] rows = new int[3];
    int[] diags = new int[2];
    int n = 3;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        cols[j] += board[i][j];
        rows[i] += board[i][j];
        if (i == j) diags[0] += board[i][j];
        if (n - i - 1 == j) diags[1]+= board[i][j];
      }
    }
    for (int i = 0; i < n; ++i) {
      if (cols[i] % 'X' == 0 || cols[i] % 'O' == 0) return cols[i] % 'X' == 0 ? 'X' : 'O';
      if (rows[i] % 'X' == 0 || rows[i] % 'O' == 0) return rows[i] % 'X' == 0 ? 'X' : 'O';
    }

    for (int i = 0; i < n - 1; ++i) {
      if (diags[i] % 'X' == 0 || diags[i] % 'O' == 0) return diags[i] % 'X' == 0 ? 'X' : 'O';
    }

    return '\0';
  }
 
  // Check whether the game is ended
  public static char gameEnded(char[][] board) {
    if (checkWinner(board) != '\0') return '+';

    for (int i = 0; i  < 3; ++i) {
      for (int j =0; j < 3; ++j) {
        if (board[i][j] == '-') return '-';
      }
    }
    return '+';
  }

}
